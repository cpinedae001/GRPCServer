/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import com.pruebas.grpcserver.User;
import com.pruebas.grpcserver.User.APIResponse;
import com.pruebas.grpcserver.userGrpc;
import com.pruebas.http.Peticiones;
import io.grpc.stub.StreamObserver;

/**
 *
 * @author christianpineda
 */
public class UserServices extends userGrpc.userImplBase {

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("");

    }

    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("Ingresando....");

        String userName = request.getUsername();
        String password = request.getPassword();
        APIResponse.Builder response = APIResponse.newBuilder();
        if (userName.equals(userName) && password.equals(password)) {
            response.setResponseCode("1").setResponsemessage("Exitoso");
            Peticiones peticion = new Peticiones();
//            peticion.senPost(userName, password);
        } else {
            response.setResponseCode("404").setResponsemessage("invalid password");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();

    }

}
