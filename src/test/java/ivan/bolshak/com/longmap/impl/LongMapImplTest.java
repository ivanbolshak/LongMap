package ivan.bolshak.com.longmap.impl;

import ivan.bolshak.com.longmap.LongMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ivan on 18.08.2016.
 */
public class LongMapImplTest {
    LongMap<String> longMap;
    int countPoint = 555;

    @Before
    public void setUpAndPutTest() throws Exception {
        longMap = new LongMapImpl<>();

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
        assertTrue("map Empty", true);
    }

    @Test
    public void testIsEmptyFalse() throws Exception {
        assertFalse("map NotEmpty", false);
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

    }

    @Test
    public void testValues() throws Exception {
        Object [] arrValue = longMap.values();
        assertEquals(longMap.size(), arrValue.length);
        assertTrue(arrValue[1] instanceof String);
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
}