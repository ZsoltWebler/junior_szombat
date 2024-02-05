package java_collections.tests;

import java_collections.Computer;
import java_collections.ComputerDatabase;
import java_collections.ComputerStorageSystem;
import java_collections.StorageType;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComputerStorageSystemTest {

    private final ComputerStorageSystem computerStorageSystem = new ComputerStorageSystem();

    @Test
    public void getAllComputerTest() {

        List<Computer> expected = ComputerDatabase.getComputers();
        List<Computer> actual = computerStorageSystem.getAllComputer();
        assertEquals(100, actual.size());
        assertEquals(expected, actual);

    }

    @Test
    public void getAllComputersWithIntelCPUTest() {
        List<Computer> actual = computerStorageSystem.getAllComputersWithIntelCPU();

        assertEquals(64, actual.size());
        for (Computer c : actual) {
            assertTrue(c.getCPU().startsWith("Intel"));
        }
    }

    @Test
    public void getAllComputersWithAmdCPUTest() {
        List<Computer> actual = computerStorageSystem.getAllComputersWithAmdCPU();

        assertEquals(36, actual.size());
        for (Computer c : actual) {
            assertTrue(c.getCPU().startsWith("AMD"));
        }
    }

    @Test
    public void getAllComputersWithGeForceGPUTest() {
        List<Computer> actual = computerStorageSystem.getAllComputersWithGeForceGPU();

        assertEquals(67, actual.size());
        for (Computer c : actual) {
            assertTrue(c.getGPU().startsWith("GeForce"));
        }
    }

    @Test
    public void getAllComputersWithRadeonGPUTest() {
        List<Computer> actual = computerStorageSystem.getAllComputersWithRadeonGPU();

        assertEquals(33, actual.size());
        for (Computer c : actual) {
            assertTrue(c.getGPU().startsWith("Radeon"));
        }
    }

    @Test
    public void getAllComputersWithMoreThan16GBRam() {
        List<Computer> actual = computerStorageSystem.getAllComputersWithMoreThan16GBRam();

        assertEquals(50, actual.size());
        for (Computer c : actual) {
            assertTrue(c.getRamCapacity() > 16);
        }
    }

    @Test
    public void testGetAllComputersGroupedByStorageType() {

        Map<StorageType, List<Computer>> actual = computerStorageSystem.getAllComputersGroupedByStorageType();

        assertEquals(Set.of(StorageType.SSD, StorageType.HDD), actual.keySet());

        assertEquals(56,actual.get(StorageType.HDD).size());
        assertEquals(44,actual.get(StorageType.SSD).size());


        for (StorageType storageType : actual.keySet()) {
            for (Computer computer : actual.get(storageType)) {

                assertEquals(storageType, computer.getStorageType());
            }
        }

    }

}
