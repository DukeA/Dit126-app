package dit126.controller;

import dit126.controller.search.Search;
import dit126.controller.search.SearchEnum;
import dit126.controller.search.SearchResult;
import dit126.model.entity.ActivityEntity;
import dit126.model.entity.LocationEntity;
import dit126.model.facade.SearchFacade;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class SearchTest {

    @Mock
    private SearchResult searchResult;

    @Mock
    private SearchFacade searchFacade;

    @Mock
    private Search search;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        search = new Search();
    }

    @Test
    public void typeSearchInput() {
        this.searchInput("jogging", SearchEnum.TYPE);
    }

    @Test
    public void citySearchInput() {
        this.searchInput("gothenburg", SearchEnum.CITY);
    }

    @Test
    public void search() {
        List<ActivityEntity> result = new ArrayList<>();
        ActivityEntity entity = new ActivityEntity();
        LocationEntity location = new LocationEntity();

        location.setCity("gothenburg");
        entity.setType("JOGGING");
        entity.setLocationByLocationId(location);
        result.add(entity);

        when(searchFacade.findByCity("gothenburg")).thenReturn(result);
        when(searchResult.getActivityEntities()).thenReturn(result);

        assertEquals(1, searchResult.getActivityEntities().size());
        assertEquals(entity, searchResult.getActivityEntities().get(0));
        assertEquals("gothenburg", searchResult.getActivityEntities().get(0).getLocationByLocationId().getCity());
        assertEquals("JOGGING", searchResult.getActivityEntities().get(0).getType());
    }

    private void searchInput(String text, SearchEnum option) {
        search.setText(text);
        search.setSearchEnum(option);

        when(searchResult.getSearchEnum()).thenReturn(option);
        when(searchResult.getText()).thenReturn(text);

        assertEquals(text, searchResult.getText());
        assertEquals(option, searchResult.getSearchEnum());
    }

}
