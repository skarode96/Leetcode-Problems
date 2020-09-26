package amazon.question2;

import java.util.List;

public class Question2 {

    public int checkWinner(List<List<String>> codeList, List<String> shoppingCart){
        // If Code size is emtpy customer is winner
        if(codeList.size() == 0){
            return 1;
        }

        int currentCodeIndex = 0;
        int currentCartIndex = 0;

        // Loop through order and check if code matches
        while (currentCartIndex < shoppingCart.size()){

            // Check if code matches current order
            if(isCodeMatchingOrder(codeList.get(currentCodeIndex), shoppingCart, currentCartIndex)){
                // Increment current order index with matching code size
                currentCartIndex += codeList.get(currentCodeIndex).size();
                currentCodeIndex += 1;

                // If all codes are matched return
                if(currentCodeIndex == codeList.size()){
                    return 1;
                }

            }else{
                // Increment counter to next order item
                currentCartIndex++;
            }
        }

        // If all code are matched then customer is winner
        return currentCodeIndex == codeList.size() ? 1: 0;
    }

    private boolean isCodeMatchingOrder(List<String> codeString, List<String> shoppingCart, int startingIndex) {
        // Check if code is greater than remaining orders
        if(startingIndex + codeString.size() > shoppingCart.size()){
            return false;
        }

        // Check if code matches the order
        for(String code: codeString){

            // code is anything or matches increment counter
            if(!(code.equals("anything") || code.equals(shoppingCart.get(startingIndex++)))) {
                return false;
            }
        }

        // Check if entire code was matched
        return true;
    }

}
