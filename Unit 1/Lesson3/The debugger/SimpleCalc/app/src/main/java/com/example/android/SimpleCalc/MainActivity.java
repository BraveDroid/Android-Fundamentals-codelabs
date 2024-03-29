/*
 * Copyright 2018, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.SimpleCalc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * SimpleCalc is the initial version of SimpleCalcTest.  It has
 * a number of intentional oversights for the student to debug/fix,
 * including input validation (no input, bad number format, div by zero)
 * <p>
 * In addition there is only one (simple) unit test in this app.
 * All the input validation and the unit tests are added as part of the lessons.
 */
public class MainActivity extends Activity {

    private static final String TAG = "CalculatorActivity";

    private Calculator mCalculator;

    private EditText mOperandOneEditText;
    private EditText mOperandTwoEditText;

    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the calculator class and all the views
        mCalculator = new Calculator();
        mResultTextView = findViewById(R.id.operation_result_text_view);
        mOperandOneEditText = findViewById(R.id.operand_one_edit_text);
        mOperandTwoEditText = findViewById(R.id.operand_two_edit_text);
    }

    /**
     * OnClick method called when the add Button is pressed.
     */
    public void onAdd(View view) {
        compute(Calculator.Operator.ADD);
    }

    /**
     * OnClick method called when the subtract Button is pressed.
     */
    public void onSub(View view) {
        compute(Calculator.Operator.SUB);
    }

    /**
     * OnClick method called when the divide Button is pressed.
     */
    public void onDiv(View view) {
        try {
            compute(Calculator.Operator.DIV);
        } catch (IllegalArgumentException iae) {
            Log.e(TAG, "IllegalArgumentException", iae);
            mResultTextView.setText(getString(R.string.computationError));
        }
    }

    /**
     * OnClick method called when the multiply Button is pressed.
     */
    public void onMul(View view) {
        compute(Calculator.Operator.MUL);
    }

    /**
     * OnClick method called when the power Button is pressed.
     */
    public void onPow(View view) {
        try {
            compute(Calculator.Operator.POW);
        } catch (IllegalArgumentException iae) {
            Log.e(TAG, "IllegalArgumentException", iae);
            mResultTextView.setText(getString(R.string.computationError));
        }
    }

    private void compute(Calculator.Operator operator) {
        double operandOne;
        double operandTwo;
        if ((validateOperandNotEmpty(mOperandOneEditText)) && (validateOperandNotEmpty(mOperandTwoEditText))) {
            try {
                operandOne = getOperand(mOperandOneEditText);
                operandTwo = getOperand(mOperandTwoEditText);
            } catch (NumberFormatException nfe) {
                Log.e(TAG, "NumberFormatException", nfe);
                mResultTextView.setText(getString(R.string.computationError));
                return;
            }
            String result = null;
            switch (operator) {
                case ADD:
                    result = String.valueOf(
                            mCalculator.add(operandOne, operandTwo));
                    break;
                case SUB:
                    result = String.valueOf(
                            mCalculator.sub(operandOne, operandTwo));
                    break;
                case DIV:
                    if (operandOne != 0 && operandTwo != 0) {
                        result = String.valueOf(
                                mCalculator.div(operandOne, operandTwo));
                    } else {
                        Toast.makeText(this, "cannot divide by zero 0", Toast.LENGTH_LONG).show();
                    }
                    break;
                case MUL:
                    result = String.valueOf(
                            mCalculator.mul(operandOne, operandTwo));
                    break;
                case POW:
                    if ((operandOne == 0.0 && operandTwo < 0.0) || operandOne == -0 && operandTwo < 0) {
                        Toast.makeText(this, "operand one shouldn't be 0 and second operand shouldn't be negative", Toast.LENGTH_LONG).show();

                    } else {
                        result = String.valueOf(
                                mCalculator.pow(operandOne, operandTwo));
                    }
                    break;
                default:
                    result = getString(R.string.computationError);
                    break;
            }
            mResultTextView.setText(result);
        } else {
            Toast.makeText(this, "empty operand", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * @return the operand value entered in an EditText as double.
     */
    private static Double getOperand(EditText operandEditText) {
        String operandText = getOperandText(operandEditText);
        Double operand = null;
        try {
            operand = Double.valueOf(operandText);
        } catch (IllegalArgumentException ex) {
            Log.e(TAG, "NumberFormatException", ex);
        }
        return operand;
    }

    private static boolean validateOperandNotEmpty(EditText operandEditText) {
        String operandText = getOperandText(operandEditText);
        boolean isValidOperand;
        try {
            Double.valueOf(operandText);
            isValidOperand = true;
        } catch (IllegalArgumentException ex) {
            isValidOperand = false;
        }
        return isValidOperand;
    }

    /**
     * @return the operand text which was entered in an EditText.
     */
    private static String getOperandText(EditText operandEditText) {
        return operandEditText.getText().toString();
    }
}
