/**
 * 
 */
package labBalloon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Cyanuro
 *
 */
public enum Size {
	
	XS, S, M, L, XL;


public static Size randomEnumGenerator() {
	
	List<Size> enumSizeArrayList = new ArrayList<>(Arrays.asList(Size.values()));
	Random randomEnum = new Random();
	int randomSizeNumber = randomEnum.nextInt(enumSizeArrayList.size());
	Size randomEnumSize = enumSizeArrayList.get(randomSizeNumber);
	
	return randomEnumSize;
	
	}
}
	
