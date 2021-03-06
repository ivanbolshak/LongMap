package ivan.bolshak.com.longmap.impl;

import ivan.bolshak.com.longmap.LongMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Ivan on 18.08.2016.
 */
public class LongMapImplTest {
    LongMap<String> longMap;
    int countPoint;

    @Before
    public void setUpAndPutTest() throws Exception {
        longMap = new LongMapImpl<>();
        countPoint = 555;

        for (int i=0; i<countPoint; i++){
            longMap.put((long) i, String.valueOf("str_"+(i)));
        }
    }

    @Test
    public void testGet() throws Exception {

        assertEquals("try get by index 1", "str_1", longMap.get(1));
    }

    @Test
    public void testRemove() throws Exception {
        assertEquals("try remove by index 3", "str_3", longMap.remove(3));
    }

    @Test
    public void testRemoveCheckNull() throws Exception {
        long index = 3;
        longMap.remove(index);
        assertNull("check NULL after remove by index", longMap.get(3));
    }

    @Test
    public void testIsEmptyTrue() throws Exception {
        LongMap<Integer> longMapEmpty = new LongMapImpl<>();
        assertTrue("map Empty", longMapEmpty.isEmpty());
    }

    @Test
    public void testIsEmptyFalse() throws Exception {
        assertFalse("map NotEmpty",  longMap.isEmpty());
    }

    @Test
    public void testContainsKey() throws Exception {
        assertTrue(longMap.containsKey(1));
    }

    @Test
    public void testContainsValue() throws Exception {
        assertTrue(longMap.containsValue("str_1"));
    }

    @Test
    public void testKeys() throws Exception {
        long [] arrKeys = longMap.keys();
        assertEquals(longMap.size(), arrKeys.length);
        assertFalse(arrKeys[0]==arrKeys[arrKeys.length-1]);
        for (long arrKey : arrKeys) {
            assertTrue(longMap.containsKey(arrKey));
        }
    }

    @Test
    public void testValues() throws Exception {
        Object [] arrValue = longMap.values();
        assertEquals(longMap.size(), arrValue.length);
        assertFalse(arrValue[0].equals(arrValue[arrValue.length-1]));
        for (int i=0; i<arrValue.length; i++){
            assertTrue(longMap.containsValue((String) arrValue[i]));
        }
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(countPoint , longMap.size());
    }

    @Test
    public void testClear() throws Exception {
        longMap.clear();
        assertTrue(longMap.isEmpty());
    }

    @Test
    public void testToString() throws Exception{
        LongMap<String>longMapToString = new LongMapImpl<>();
        int countPointToString = 3;

        for (int i=0; i<countPointToString; i++){
            longMapToString.put((long) i, String.valueOf("str_"+(i)));
        }

        String strExample = "{0=str_0, 1=str_1, 2=str_2}";

        assertEquals(strExample, longMapToString.toString());

    }
}