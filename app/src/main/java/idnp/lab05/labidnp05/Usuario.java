package idnp.lab05.labidnp05;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

public class Usuario implements Parcelable, Comparable<Usuario>{
    private int dni;
    private String names;
    private String lastnames;
    private String birthday;
    private String college;
    private String carreer;

    public Usuario(int dni, String names, String lastnames, String birthday, String college, String carreer) {
        this.dni = dni;
        this.names = names;
        this.lastnames = lastnames;
        this.birthday = birthday;
        this.college = college;
        this.carreer = carreer;
    }

    public int getDni() {
        return dni;
    }

    public String getNames() {
        return names;
    }

    public String getLastnames() {
        return lastnames;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getCollege() {
        return college;
    }

    public String getCarreer() {
        return carreer;
    }

    protected Usuario(Parcel in) {
        dni = in.readInt();
        names = in.readString();
        lastnames = in.readString();
        birthday = in.readString();
        college = in.readString();
        carreer = in.readString();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(dni);
        parcel.writeString(names);
        parcel.writeString(lastnames);
        parcel.writeString(birthday);
        parcel.writeString(college);
        parcel.writeString(carreer);
    }

    @Override
    public int compareTo(Usuario o) {
        return this.getDni() - o.getDni();
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "dni=" + dni +
                ", names='" + names + '\'' +
                ", lastnames='" + lastnames + '\'' +
                ", birthday='" + birthday + '\'' +
                ", college='" + college + '\'' +
                ", carreer='" + carreer + '\'' +
                '}';
    }
}
