package Services;


import ServicesInterface.CollectionServiceInterface;
import dao.CollectionCustom;
import dao.MCollectionMapper;
import model.MCollection;
import model.MCollectionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService implements CollectionServiceInterface {



    @Autowired
    MCollectionMapper mCollectionMapper;

    @Autowired
    CollectionCustom collectionCustom;



    @Override
    public List<MCollection> getCollection(int uid) {
        MCollectionExample mCollectionExample = new MCollectionExample();
        mCollectionExample.createCriteria().andUidEqualTo(uid);
        List<MCollection> mCollections= mCollectionMapper.selectByExample(mCollectionExample);
        return  mCollections;
    }




    @Override
    public int setCollection(MCollection mCollection) {
        return  mCollectionMapper.insert(mCollection);
    }

    @Override
    public MCollection  getConleectionInfo(MCollection mCollection){
        return  collectionCustom.selectisCollection(mCollection);
    }




}
