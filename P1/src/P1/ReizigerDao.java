package P1;

import java.util.*;

public interface ReizigerDao {

    public List<Reiziger> findAll();
    public List<Reiziger> findByGBdatum(String GBdatum);
    public Reiziger update(Reiziger reiziger);
    public Reiziger save(Reiziger reiziger);
    public boolean delete(Reiziger reiziger);
}