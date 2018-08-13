package denis.agence;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Zoom on 10/1/2018.
 */

public class DataBaseHelper extends SQLiteOpenHelper {


    public DataBaseHelper(Context context) {
        super(context, DataBaseOptions.DB_NAME, null, DataBaseOptions.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create table
        db.execSQL(DataBaseOptions.CREATE_USERS_TABLE_);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseOptions.USERS_TABLE);
        onCreate(db);
    }

    public Usuario queryUser(String usuario, String senha) {

        SQLiteDatabase db = this.getReadableDatabase();
        Usuario user = null;

        Cursor cursor = db.query(DataBaseOptions.USERS_TABLE, new String[]{DataBaseOptions.ID,
                        DataBaseOptions.USUARIO, DataBaseOptions.SENHA}, DataBaseOptions.USUARIO + "=? and " + DataBaseOptions.SENHA + "=?",
                new String[]{usuario, senha}, null, null, null, "1");
        if (cursor != null)
            cursor.moveToFirst();
        if (cursor != null && cursor.getCount() > 0) {
            user = new Usuario(cursor.getString(1), cursor.getString(2));
        }
        return user;
    }

    public void addUser(Usuario user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DataBaseOptions.USUARIO, user.getUsuario());
        values.put(DataBaseOptions.SENHA, user.getSenha());

        db.insert(DataBaseOptions.USERS_TABLE, null, values);
        db.close(); // Encerrando a conexão

    }

}
