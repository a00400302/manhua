package ServicesInterface;

import model.MCollection;

import java.util.List;

public interface CollectionServiceInterface {


    public List<MCollection> getCollection(int uid) ;


    public int setCollection(MCollection mCollection);

    public MCollection  getConleectionInfo(MCollection mCollection);
}
