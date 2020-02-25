package assignment_7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Shivam
 *  TestSparseManipulations is created to Test SparseManipulations class methods
 */
public class TestSparseManipulations {

	// test for null value as input
	@Test
	public void testMatrixNullArray() {
		try {
			new SparseManipulation(null);
		} catch (Exception e) {
			assertEquals(" NUll Value Array Passed", e.getMessage());
		}
	}

	// test for Empty Array input
	@Test
	public void testMatrixEmptyArray() {
		try {
			new SparseManipulation(new int[][] {});
		} catch (Exception e) {
			assertEquals(" Empty Array ", e.getMessage());
		}
	}

	// Addition operation of two matrix of different size
	@Test
	public void testMatrixAdditionDifferentSizedMatrices() {
		try {
			SparseManipulation mo = new SparseManipulation(new int[][] { { 2, 3 }, { 5, 6 }, { 6, 9 } });
			SparseManipulation mo1 = new SparseManipulation(new int[][] { { 2, 2, 2, 2 }, { 2, 2, 2, 2 } });
			mo.addMatrix(mo, mo1);
		} catch (Exception e) {
			assertEquals(" both matrix are of different size can't perform addition operation ", e.getMessage());
		}
	}

	// Addition operation when input is null value
	@Test
	public void testMatrixNullValuePassedForAddition() {
		try {
			new SparseManipulation(new int[][] { { 1, 2 }, { 2, 1 } }).addMatrix(null, null);
		} catch (Exception e) {
			assertEquals(" NUll Value Object Passed", e.getMessage());
		}
	}

	// positive test case for addition operation
	@Test
	public void test_addMatrix() throws Exception{
		SparseManipulation mo = new SparseManipulation(new int[][] { { 2, 3 }, { 5, 6 }, { 6, 9 } });
		SparseManipulation mo1 = new SparseManipulation(new int[][] { { 2, 2 }, { 2, 2 }, { 2, 2 } });
		int returnedArrOperation[][] = mo.addMatrix(mo, mo1);
		int[][] expectedArr = new int[][] { { 4, 5 }, { 7, 8 }, { 8, 11 } };
		Assert.assertArrayEquals(expectedArr, returnedArrOperation);
	}

	// test for multiplication of two matrices with n x m and p x q size
	@Test
	public void testMatrixMultiplicationDifferentSizedMatrices() {
		try {
			SparseManipulation mo = new SparseManipulation(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
			SparseManipulation mo1 = new SparseManipulation(new int[][] { { 2, 2, 2, 2 }, { 2, 2, 2, 2 } });
			mo.multiplyMatrix(mo, mo1);
		} catch (Exception e) {
			assertEquals(" Multiplication Can't be performed ", e.getMessage());
		}
	}

	// positive test case for matrix multiplication
	@Test
	public void test_multiplyMatrix()throws Exception{
		SparseManipulation mo = new SparseManipulation(new int[][] { { 2, 3 }, { 5, 6 }, { 6, 9 } });
		SparseManipulation mo1 = new SparseManipulation(new int[][] { { 2, 2, 2, 2 }, { 2, 2, 2, 2 } });
		int returnedArrOperation[][] = mo.multiplyMatrix(mo, mo1);
		int[][] expectedArr = new int[][] { { 10, 10, 10, 10 }, { 22, 22, 22, 22 }, { 30, 30, 30, 30 } };
		Assert.assertArrayEquals(expectedArr, returnedArrOperation);
	}

	// test for null value inputs in matrix multiplication
	@Test
	public void testMatrixNullValuePassedForMultiplication() {
		try {
			new SparseManipulation(new int[][] { { 1, 2 }, { 2, 1 } }).multiplyMatrix(null, null);
		} catch (Exception e) {
			assertEquals(" NUll Value Object Passed", e.getMessage());
		}
	}

	// test for transpose of matrix
	@Test
	public void testTransposeMatrix()throws Exception{
		SparseManipulation mo = new SparseManipulation(new int[][] { { 2, 3 }, { 5, 6 }, { 6, 9 } });
		int returnedArrOperation[][] = mo.matrixTranspose();
		int[][] expectedArr = new int[][] { { 2, 5, 6 }, { 3, 6, 9 } };
		Assert.assertArrayEquals(expectedArr, returnedArrOperation);
	}

	// positive test case for symmetric matrix
	@Test
	public void testSymmetricMatrix_positive()throws Exception{
		SparseManipulation mo = new SparseManipulation(new int[][] { { 1, 2, 3 }, { 2, 5, 4 }, { 3, 4, 9 } });
		assertTrue(mo.isSymmetric());
	}

	// negative test case for symmetric matrix where matrix is of n x m size
	@Test
	public void testSymmetricMatrix_Negative_Row_Column_Not_Same() throws Exception {
		SparseManipulation mo = new SparseManipulation(new int[][] { { 2, 3 }, { 5, 4 }, { 4, 9 } });
		assertFalse(mo.isSymmetric());
	}

	// negative test case for symmetric matrix where matrix is of n x n size
	@Test
	public void testSymmetricMatrix_Negative()throws Exception{
		SparseManipulation mo = new SparseManipulation(new int[][] { { 2, 3, 1 }, { 5, 4, 6 }, { 7, 8, 9 } });
		assertFalse(mo.isSymmetric());
	}

}
