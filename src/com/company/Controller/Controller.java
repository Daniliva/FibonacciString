package com.company.Controller;

import com.company.Service.FibonacciServer;


import java.util.List;


import static com.company.Controller.EnterOrOutCommandString.*;

public class Controller {

    private void workOutPutSimpleNumber() {
        FibonacciServer fibonacciServer = new FibonacciServer();
        String question = "Do you wont to start?\n";
        while (answerForContinue(question)) {
            long lower = (long) inputDouble(" lower:");
            long upper = (long) inputDouble(" upper:");
            if (lower < upper) {
                List<Long> result = fibonacciServer.getFibonacciRow(lower, upper);
                enterListInteger(result);
            }
            question = "Do you wont continue program?\n";
        }
    }

    public void enterListInteger(List<Long> result) {
        String resultOut = "";
        for (Long longer : result) {
            resultOut += longer.toString() + ",";
        }
        resultOut = resultOut.substring(0, resultOut.length() - 1);

        outputStr(resultOut);
    }

    public void run() {
        workOutPutSimpleNumber();
    }
}
