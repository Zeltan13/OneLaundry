package Model;

import Controller.TransactionController;
import View.Login;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        TransactionController transactionController = new TransactionController();
        int jumTransaksi;
        Object[][] Object;
        jumTransaksi = transactionController.countOfAdminTransaction(Login.adminId);
        if (jumTransaksi==0){
            Object = new Object[1][7];
        }else{
            Object = new Object[jumTransaksi][7];
        }
        ArrayList<ModelTransaksi> listTransaksi;
        listTransaksi = transactionController.getTransactionData();

        for (int i=0; i<listTransaksi.size();i++){
            if (listTransaksi.get(i).getIdAdmin()== Login.adminId){
                for (int j=0;j<7;j++){
                    if (j==0){
                        Object[i][j] = listTransaksi.get(i).getIdTransaksi();
                    }else if (j==1){
                        Object[i][j] = listTransaksi.get(i).getIdCustomer();
                    }else if (j==2){
                        Object[i][j] = listTransaksi.get(i).getLayanan();
                    }else if (j==3){
                        Object[i][j] = listTransaksi.get(i).getStatus();
                    }else if (j==4){
                        Object[i][j] = listTransaksi.get(i).getTgl();
                    }else if (j==5){
                        Object[i][j] = listTransaksi.get(i).getItem();
                    }else if (j==6){
                        Object[i][j] = listTransaksi.get(i).getTotal();
                    }
                }
            }
        }
    }
    
}
