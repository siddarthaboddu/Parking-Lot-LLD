package com.example.parkinglot;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.parkinglot.controller.EntryPointController;
import com.example.parkinglot.controller.ExitPointController;
import com.example.parkinglot.controller.ParkingTicketController;
import com.example.parkinglot.exception.SlotNotAvailableException;
import com.example.parkinglot.model.Bike;
import com.example.parkinglot.model.Car;
import com.example.parkinglot.model.EntryPoint;
import com.example.parkinglot.model.ExitPoint;
import com.example.parkinglot.model.ParkingCharge;
import com.example.parkinglot.model.ParkingTicket;
import com.example.parkinglot.repository.EntryPointRepository;
import com.example.parkinglot.repository.ExitPointRepository;
import com.example.parkinglot.repository.ParkingTicketRepository;
import com.example.parkinglot.repository.SlotRepository;
import com.example.parkinglot.service.EntryPointService;
import com.example.parkinglot.service.ExitPointService;
import com.example.parkinglot.service.ParkingTicketService;
import com.example.parkinglot.strategy.ParkingChargeStrategy;
import com.example.parkinglot.strategy.SimpleSlotAllocationStrategy;
import com.example.parkinglot.strategy.SlotAllocationStrategy;
import com.example.parkinglot.strategy.TimeBasedParkingChargeStrategy;

public class ParkingLotTest {

	@Test
	public void getAllEntryPointsTest() {
		EntryPointRepository entryPointRepository = new EntryPointRepository(4);
		EntryPointService entryPointService = new EntryPointService(entryPointRepository);
		EntryPointController entryPointController = new EntryPointController(entryPointService);

		List<EntryPoint> entryPointsList = entryPointController.getAllEntryPoints();
		System.out.println(entryPointsList);
	}

	@Test
	public void getAllExitPointsTest() {
		ExitPointRepository exitPointRepository = new ExitPointRepository(4);
		ExitPointService exitPointService = new ExitPointService(exitPointRepository);
		ExitPointController exitPointController = new ExitPointController(exitPointService);

		List<ExitPoint> exitPointsList = exitPointController.getAllExitPoints();
		System.out.println(exitPointsList);
	}

	@Test
	public void getAllSlots() {
		SlotRepository slotRepository = new SlotRepository(2, 2, 4);
		System.out.println(slotRepository.getAllSlots());

	}

	@Test
	public void parkCarTest() {
		EntryPointRepository entryPointRepository = new EntryPointRepository(4);
		EntryPointService entryPointService = new EntryPointService(entryPointRepository);
		EntryPointController entryPointController = new EntryPointController(entryPointService);

		ExitPointRepository exitPointRepository = new ExitPointRepository(4);
		ExitPointService exitPointService = new ExitPointService(exitPointRepository);
		ExitPointController exitPointController = new ExitPointController(exitPointService);

		SlotRepository slotRepository = new SlotRepository(2, 2, 4);
		System.out.println(slotRepository.getAllSlots());
		SlotAllocationStrategy slotAllocationStrategy = new SimpleSlotAllocationStrategy(slotRepository);

		ParkingTicketRepository parkingTicketRepository = new ParkingTicketRepository();
		ParkingChargeStrategy parkingChargeStrategy = new TimeBasedParkingChargeStrategy();

		ParkingTicketService parkingTicketService = new ParkingTicketService(slotAllocationStrategy,
				parkingTicketRepository, parkingChargeStrategy);
		ParkingTicketController parkingTicketController = new ParkingTicketController(parkingTicketService);

		EntryPoint entryPoint = entryPointController.getAllEntryPoints().get(0);
		ExitPoint exitPoint = exitPointController.getAllExitPoints().get(0);

		Car car = new Car("TS-001", "RED", 2);
		System.out.println("car : " + car);

		ParkingTicket parkingTicket = parkingTicketController.createParkingTicket(entryPoint, car);
		System.out.println("parkingTicket : " + parkingTicket);

		ParkingCharge parkingCharge = parkingTicketController.closeParkingTicket(exitPoint, parkingTicket);
		System.out.println("parkingCharge : " + parkingCharge);
	}
	
	@Test
	public void parkCarTest_AboveLimit() {
		EntryPointRepository entryPointRepository = new EntryPointRepository(4);
		EntryPointService entryPointService = new EntryPointService(entryPointRepository);
		EntryPointController entryPointController = new EntryPointController(entryPointService);

		ExitPointRepository exitPointRepository = new ExitPointRepository(4);
		ExitPointService exitPointService = new ExitPointService(exitPointRepository);
		ExitPointController exitPointController = new ExitPointController(exitPointService);

		SlotRepository slotRepository = new SlotRepository(2, 2, 4);
		System.out.println(slotRepository.getAllSlots());
		SlotAllocationStrategy slotAllocationStrategy = new SimpleSlotAllocationStrategy(slotRepository);

		ParkingTicketRepository parkingTicketRepository = new ParkingTicketRepository();
		ParkingChargeStrategy parkingChargeStrategy = new TimeBasedParkingChargeStrategy();

		ParkingTicketService parkingTicketService = new ParkingTicketService(slotAllocationStrategy,
				parkingTicketRepository, parkingChargeStrategy);
		ParkingTicketController parkingTicketController = new ParkingTicketController(parkingTicketService);

		EntryPoint entryPoint = entryPointController.getAllEntryPoints().get(0);
		ExitPoint exitPoint = exitPointController.getAllExitPoints().get(0);

		List<Car> cars = new ArrayList<>();
		List<ParkingTicket> parkingTickets = new ArrayList<>();
		List<ParkingCharge> parkingCharges = new ArrayList<>();
		
		for(int i=0;i<8;i++) {
			Car car = new Car("TS-00"+(i+1), "RED", 2);
			cars.add(car);
			
			ParkingTicket parkingTicket = parkingTicketController.createParkingTicket(entryPoint, car);
			parkingTickets.add(parkingTicket);
		}
		
		Car car = new Car("TS-005", "RED", 2);
		Assertions.assertThrows(SlotNotAvailableException.class, ()->{
			parkingTicketController.createParkingTicket(entryPoint, car);
		});
	}
	
	@Test
	public void parkBikeTest() {
		EntryPointRepository entryPointRepository = new EntryPointRepository(4);
		EntryPointService entryPointService = new EntryPointService(entryPointRepository);
		EntryPointController entryPointController = new EntryPointController(entryPointService);

		ExitPointRepository exitPointRepository = new ExitPointRepository(4);
		ExitPointService exitPointService = new ExitPointService(exitPointRepository);
		ExitPointController exitPointController = new ExitPointController(exitPointService);

		SlotRepository slotRepository = new SlotRepository(2, 2, 4);
		System.out.println(slotRepository.getAllSlots());
		SlotAllocationStrategy slotAllocationStrategy = new SimpleSlotAllocationStrategy(slotRepository);

		ParkingTicketRepository parkingTicketRepository = new ParkingTicketRepository();
		ParkingChargeStrategy parkingChargeStrategy = new TimeBasedParkingChargeStrategy();

		ParkingTicketService parkingTicketService = new ParkingTicketService(slotAllocationStrategy,
				parkingTicketRepository, parkingChargeStrategy);
		ParkingTicketController parkingTicketController = new ParkingTicketController(parkingTicketService);

		EntryPoint entryPoint = entryPointController.getAllEntryPoints().get(0);
		ExitPoint exitPoint = exitPointController.getAllExitPoints().get(0);

		Bike bike = new Bike("TS-001", "RED", 1);
		System.out.println("bike : " + bike);

		ParkingTicket parkingTicket = parkingTicketController.createParkingTicket(entryPoint, bike);
		System.out.println("parkingTicket : " + parkingTicket);

		ParkingCharge parkingCharge = parkingTicketController.closeParkingTicket(exitPoint, parkingTicket);
		System.out.println("parkingCharge : " + parkingCharge);
	}
}
