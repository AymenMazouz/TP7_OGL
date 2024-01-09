import com.example.exception.NoSquareException;
import com.example.model.Matrix;
import com.example.service.MatrixMathematics;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MatrixSteps {
    double det ;
    Matrix transposeMatrix ;
    Matrix inverseMatrix ;
    Matrix cofactorMatrix ;
    Matrix mat;

    @Given("I have A Matrix")
    public void iHaveAMatrix() {
         mat=new Matrix();
    }

    @When("I compute determinant of")
    public void iComputeDeterminantOf(DataTable table) throws NoSquareException {
        double [][] data = new double[3][3];
        List<Map<String, Double>> rows = table.asMaps(String.class, Double.class);
        int i =0;
        for (Map<String, Double> columns : rows){
            int j =0;
            data[i][j]= columns.get("col1");
            data[i][j+1] = columns.get("col2");
            data[i][j+2]= columns.get("col3");
            i=i+1;
        }
        mat.setData(data);
        det = MatrixMathematics.determinant(mat);
    }

    @Then("The result of determinant is {}")
    public void iFindAsDeterminantResult(double arg0) {
        Assert.assertEquals(arg0,det,0);

    }


    @When("I compute transpose of")
    public void iComputeTransposeOf(DataTable table) throws NoSquareException {
        double [][] data = new double[3][2];
        List<Map<String, Double>> rows = table.asMaps(String.class, Double.class);
        int i =0;
        for (Map<String, Double> columns : rows){
            int j =0;
            data[i][j]= columns.get("col1");
            data[i][j+1] = columns.get("col2");
            i=i+1;
        }
        mat.setData(data);
        transposeMatrix = MatrixMathematics.transpose(mat);
    }

    @Then("The result of transpose is")
    public void iFindAsTransposeResult(DataTable table) {
        double [][] data = new double[2][3];
        List<Map<String, Double>> rows = table.asMaps(String.class, Double.class);
        int i =0;
        for (Map<String, Double> columns : rows){
            int j =0;
            data[i][j]= columns.get("col1");
            data[i][j+1] = columns.get("col2");
            data[i][j+2]= columns.get("col3");
            i=i+1;
        }
        Matrix result = new Matrix() ;
        result.setData(data);
        assertEquals(result,transposeMatrix);


    }

    // Inverse

    @When("I compute inverse of")
    public void iComputeInverseOf(DataTable table) throws NoSquareException {
        double [][] data = new double[2][2];
        List<Map<String, Double>> rows = table.asMaps(String.class, Double.class);
        int i =0;
        for (Map<String, Double> columns : rows){
            int j =0;
            data[i][j]= columns.get("col1");
            data[i][j+1] = columns.get("col2");
            i=i+1;
        }
        mat.setData(data);
        inverseMatrix = MatrixMathematics.inverse(mat);
    }

    @Then("The result of inverse is")
    public void iFindAsInverseResult(DataTable table) {
        double [][] data = new double[2][2];
        List<Map<String, Double>> rows = table.asMaps(String.class, Double.class);
        int i =0;
        for (Map<String, Double> columns : rows){
            int j =0;
            data[i][j]= columns.get("col1");
            data[i][j+1] = columns.get("col2");
            i=i+1;
        }
        Matrix result = new Matrix() ;
        result.setData(data);
        assertEquals(result,inverseMatrix);


    }


    // Cofactor

    @When("I compute cofactor of")
    public void iComputeCofactorOf(DataTable table) throws NoSquareException {
        double [][] data = new double[2][2];
        List<Map<String, Double>> rows = table.asMaps(String.class, Double.class);
        int i =0;
        for (Map<String, Double> columns : rows){
            int j =0;
            data[i][j]= columns.get("col1");
            data[i][j+1] = columns.get("col2");
            i=i+1;
        }
        mat.setData(data);
        cofactorMatrix = MatrixMathematics.cofactor(mat);
    }

    @Then("The result of cofactor is")
    public void iFindAsCofactoreResult(DataTable table) {
        double [][] data = new double[2][2];
        List<Map<String, Double>> rows = table.asMaps(String.class, Double.class);
        int i =0;
        for (Map<String, Double> columns : rows){
            int j =0;
            data[i][j]= columns.get("col1");
            data[i][j+1] = columns.get("col2");
            i=i+1;
        }
        Matrix result = new Matrix() ;
        result.setData(data);
        assertEquals(result,cofactorMatrix);


    }
}

