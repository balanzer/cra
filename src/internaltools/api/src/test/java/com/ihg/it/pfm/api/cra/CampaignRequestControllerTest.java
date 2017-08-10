/**
 *
 */
package com.ihg.it.pfm.api.cra;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.filters.CorsFilter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import com.ihg.it.pfm.cra.CampaignRequest;
import com.ihg.it.pfm.services.CampaignRequestProcess;
import com.ihg.it.pfm.services.error.ServiceException;

/**
 * @author varathm
 *
 */
public class CampaignRequestControllerTest extends BasicSupport {

    private MockMvc mockMvc;

    @Mock
    private CampaignRequestProcess service;

    @InjectMocks
    private CampaignRequestController controller;

    private List<CampaignRequest> createSampleForList() {
        List<CampaignRequest> output = new ArrayList<>();

        CampaignRequest campaignreq = this.getCampaignRequestSample(1);
        output.add(campaignreq);

        campaignreq = this.getCampaignRequestSample(2);
        output.add(campaignreq);

        return output;

    }

    /**
     * @param id
     * @return
     */
    private CampaignRequest getCampaignRequestSample(long id) {
        CampaignRequest campaignreq = new CampaignRequest();

        campaignreq.setId(id);
        campaignreq.setName(campaignValues.get(NAME));
        campaignreq.setDesc(campaignValues.get(DESC));
        return campaignreq;
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).addFilters(new CorsFilter()).build();
    }

    @Test
    public void testErrorWithoutHeader() throws Exception {
        when(this.service.getAll()).thenReturn(this.createSampleForList());
        this.mockMvc.perform(get("/cra")).andExpect(status().isBadRequest());
    }

    @Test
    public void testGet() throws Exception {

        when(this.service.get(anyLong())).thenReturn(this.getCampaignRequestSample(101));

        this.mockMvc.perform(get("/cra/101").header("SM_USER", "ut")).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(101))).andExpect(jsonPath("$.name", is(campaignValues.get(NAME))));

        verify(this.service, times(1)).get(anyLong());
    }

    @Test
    public void testGetAll() throws Exception {
        when(this.service.getAll()).thenReturn(this.createSampleForList());

        this.mockMvc.perform(get("/cra").header("SM_USER", "ut")).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2))).andExpect(jsonPath("$[0].id", is(1))).andExpect(jsonPath("$[0].name", is(campaignValues.get(NAME))))
                .andExpect(jsonPath("$[1].id", is(2))).andExpect(jsonPath("$[1].name", is(campaignValues.get(NAME))));

        verify(this.service, times(1)).getAll();
    }

    @Test
    public void testGetAllNoOutput() throws Exception {
        when(this.service.getAll()).thenReturn(new ArrayList<>());

        this.mockMvc.perform(get("/cra").header("SM_USER", "ut")).andExpect(status().isNoContent());

        verify(this.service, times(1)).getAll();
    }

    @Test(expected = NestedServletException.class)
    public void testGetException() throws Exception {
        when(this.service.get(anyLong())).thenThrow(new ServiceException("Test Error"));
        this.mockMvc.perform(get("/cra/101").header("SM_USER", "ut")).andExpect(status().isNotFound());
        verify(this.service, times(1)).get(anyLong());
    }

    @Test
    public void testGetNoRecord() throws Exception {
        when(this.service.get(anyLong())).thenReturn(null);
        this.mockMvc.perform(get("/cra/101").header("SM_USER", "ut")).andExpect(status().isNotFound());
        verify(this.service, times(1)).get(anyLong());
    }

}
