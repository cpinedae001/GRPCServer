
import io.grpc.Server;
import io.grpc.ServerBuilder;
import user.UserServices;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author christianpineda
 */
public class GRPCServices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Iniciando el servidor GRPC.....");
        try {
             Server server = ServerBuilder.forPort(8082).addService(
             
             new UserServices()).build();
        
             server.start();
             System.out.println("El servicio se ha iniciado correctamente en el puerto---> " + server.getPort());
             server.awaitTermination();
        } catch (Exception e) {
            System.out.println("Error al iniciar el servicio, verifique el puerto donde se publica el servicio.");
            e.printStackTrace();
        }
       
    }
    
}
