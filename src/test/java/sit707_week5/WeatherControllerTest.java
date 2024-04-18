package sit707_week5;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherControllerTest {
	private static WeatherController wController;
	private static int nHours;
	private static double[] temperatures;

	@BeforeClass
	public static void setupWController() {
		// Initialize controller once for all tests
		wController = WeatherController.getInstance();

		// Retrieve number of hours once
		nHours = wController.getTotalHours();

		// Store temperatures for all hours once
		temperatures = new double[nHours];
		for (int i = 0; i < nHours; i++) {
			temperatures[i] = wController.getTemperatureForHour(i + 1);
		}
	}

	@AfterClass

	public static void closeWController() {
		// Shutdown controller
		wController.close();

	}

	@Test
	public void testStudentIdentity() {
		String studentId = "222207899";
		Assert.assertNotNull("Student ID is ", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Vishuddha Samarasekara";
		Assert.assertNotNull("Student name is ", studentName);
	}

	@Test
	public void testTemperatureMin() {
		System.out.println("+++ testTemperatureMin +++");
		System.out.println("Temperature min: " + wController.getTemperatureMinFromCache());
		// Act
		double minTemperature = 1000;
		for (double temperatureVal : temperatures) {
			if (minTemperature > temperatureVal) {
				minTemperature = temperatureVal;
			}
		}
		// Assert
		Assert.assertEquals(wController.getTemperatureMinFromCache(), minTemperature, 0.001);
	}

	@Test
	public void testTemperatureMax() {
		System.out.println("+++ testTemperatureMax +++");
		System.out.println("Temperature max: " + wController.getTemperatureMaxFromCache());
		// Act
		double maxTemperature = -1;
		for (double temperatureVal : temperatures) {
			if (maxTemperature < temperatureVal) {
				maxTemperature = temperatureVal;
			}
		}
		// Assert
		Assert.assertEquals(wController.getTemperatureMaxFromCache(), maxTemperature, 0.001);
	}

	@Test
	public void testTemperatureAverage() {
		System.out.println("+++ testTemperatureAverage +++");
		System.out.println("Temperature avg: " + wController.getTemperatureAverageFromCache());
		// Act
		double sumTemp = 0;
		for (double temperatureVal : temperatures) {
			sumTemp += temperatureVal;
		}
		double averageTemp = sumTemp / nHours;

		// Assert
		Assert.assertEquals(wController.getTemperatureAverageFromCache(), averageTemp, 0.001);
	}

	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}

}
