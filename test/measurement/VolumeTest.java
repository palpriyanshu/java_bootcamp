package measurement;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VolumeTest {
    @Test
    public void shouldValidateTwoEqualVolumesOfUnitGallonsAndLiters() {
        Volume oneGallon = new Volume(1, VolumeUnit.GALLON);
        Volume oneGallonLiters = new Volume(3.78, VolumeUnit.LITER);
        assertTrue(oneGallon.isEquivalent(oneGallonLiters));
    }
}