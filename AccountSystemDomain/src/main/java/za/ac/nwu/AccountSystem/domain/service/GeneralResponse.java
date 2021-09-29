package za.ac.nwu.AccountSystem.domain.service;

import java.io.Serializable;
import java.util.Objects;

public class GeneralResponse<T> implements Serializable {
    private final boolean succesfull;
    private final transient T payload;

    public GeneralResponse(boolean succesfull, T payload){
        this.succesfull = succesfull;
        this.payload = payload;
    }

    public boolean isSuccesfull(){
        return succesfull;
    }

    public T getPayload(){
        return payload;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralResponse<?> that = (GeneralResponse<?>) o;
        return succesfull == that.succesfull && Objects.equals(payload, that.payload);
    }

    @Override
    public int hashCode() {return Objects.hash(succesfull, payload);}

    @Override
    public String toString(){
        return "GeneralResponse{" + "succesfull=" + succesfull + ", payload=" + payload + '}';
    }


}
