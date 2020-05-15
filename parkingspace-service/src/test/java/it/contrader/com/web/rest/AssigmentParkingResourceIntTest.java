package it.contrader.com.web.rest;

import it.contrader.com.ParkingspaceApp;

import it.contrader.com.domain.AssigmentParking;
import it.contrader.com.repository.AssigmentParkingRepository;
import it.contrader.com.service.AssigmentParkingService;
import it.contrader.com.service.dto.AssigmentParkingDTO;
import it.contrader.com.service.mapper.AssigmentParkingMapper;
import it.contrader.com.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;


import static it.contrader.com.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the AssigmentParkingResource REST controller.
 *
 * @see AssigmentParkingResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ParkingspaceApp.class)
public class AssigmentParkingResourceIntTest {

    private static final Instant DEFAULT_ENTRY_DATE_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_ENTRY_DATE_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private AssigmentParkingRepository assigmentParkingRepository;

    @Autowired
    private AssigmentParkingMapper assigmentParkingMapper;
    
    @Autowired
    private AssigmentParkingService assigmentParkingService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restAssigmentParkingMockMvc;

    private AssigmentParking assigmentParking;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final AssigmentParkingResource assigmentParkingResource = new AssigmentParkingResource(assigmentParkingService);
        this.restAssigmentParkingMockMvc = MockMvcBuilders.standaloneSetup(assigmentParkingResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AssigmentParking createEntity(EntityManager em) {
        AssigmentParking assigmentParking = new AssigmentParking()
            .entryDateTime(DEFAULT_ENTRY_DATE_TIME);
        return assigmentParking;
    }

    @Before
    public void initTest() {
        assigmentParking = createEntity(em);
    }

    @Test
    @Transactional
    public void createAssigmentParking() throws Exception {
        int databaseSizeBeforeCreate = assigmentParkingRepository.findAll().size();

        // Create the AssigmentParking
        AssigmentParkingDTO assigmentParkingDTO = assigmentParkingMapper.toDto(assigmentParking);
        restAssigmentParkingMockMvc.perform(post("/api/assigment-parkings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(assigmentParkingDTO)))
            .andExpect(status().isCreated());

        // Validate the AssigmentParking in the database
        List<AssigmentParking> assigmentParkingList = assigmentParkingRepository.findAll();
        assertThat(assigmentParkingList).hasSize(databaseSizeBeforeCreate + 1);
        AssigmentParking testAssigmentParking = assigmentParkingList.get(assigmentParkingList.size() - 1);
        assertThat(testAssigmentParking.getEntryDateTime()).isEqualTo(DEFAULT_ENTRY_DATE_TIME);
    }

    @Test
    @Transactional
    public void createAssigmentParkingWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = assigmentParkingRepository.findAll().size();

        // Create the AssigmentParking with an existing ID
        assigmentParking.setId(1L);
        AssigmentParkingDTO assigmentParkingDTO = assigmentParkingMapper.toDto(assigmentParking);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAssigmentParkingMockMvc.perform(post("/api/assigment-parkings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(assigmentParkingDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AssigmentParking in the database
        List<AssigmentParking> assigmentParkingList = assigmentParkingRepository.findAll();
        assertThat(assigmentParkingList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllAssigmentParkings() throws Exception {
        // Initialize the database
        assigmentParkingRepository.saveAndFlush(assigmentParking);

        // Get all the assigmentParkingList
        restAssigmentParkingMockMvc.perform(get("/api/assigment-parkings?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(assigmentParking.getId().intValue())))
            .andExpect(jsonPath("$.[*].entryDateTime").value(hasItem(DEFAULT_ENTRY_DATE_TIME.toString())));
    }
    
    @Test
    @Transactional
    public void getAssigmentParking() throws Exception {
        // Initialize the database
        assigmentParkingRepository.saveAndFlush(assigmentParking);

        // Get the assigmentParking
        restAssigmentParkingMockMvc.perform(get("/api/assigment-parkings/{id}", assigmentParking.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(assigmentParking.getId().intValue()))
            .andExpect(jsonPath("$.entryDateTime").value(DEFAULT_ENTRY_DATE_TIME.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingAssigmentParking() throws Exception {
        // Get the assigmentParking
        restAssigmentParkingMockMvc.perform(get("/api/assigment-parkings/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAssigmentParking() throws Exception {
        // Initialize the database
        assigmentParkingRepository.saveAndFlush(assigmentParking);

        int databaseSizeBeforeUpdate = assigmentParkingRepository.findAll().size();

        // Update the assigmentParking
        AssigmentParking updatedAssigmentParking = assigmentParkingRepository.findById(assigmentParking.getId()).get();
        // Disconnect from session so that the updates on updatedAssigmentParking are not directly saved in db
        em.detach(updatedAssigmentParking);
        updatedAssigmentParking
            .entryDateTime(UPDATED_ENTRY_DATE_TIME);
        AssigmentParkingDTO assigmentParkingDTO = assigmentParkingMapper.toDto(updatedAssigmentParking);

        restAssigmentParkingMockMvc.perform(put("/api/assigment-parkings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(assigmentParkingDTO)))
            .andExpect(status().isOk());

        // Validate the AssigmentParking in the database
        List<AssigmentParking> assigmentParkingList = assigmentParkingRepository.findAll();
        assertThat(assigmentParkingList).hasSize(databaseSizeBeforeUpdate);
        AssigmentParking testAssigmentParking = assigmentParkingList.get(assigmentParkingList.size() - 1);
        assertThat(testAssigmentParking.getEntryDateTime()).isEqualTo(UPDATED_ENTRY_DATE_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingAssigmentParking() throws Exception {
        int databaseSizeBeforeUpdate = assigmentParkingRepository.findAll().size();

        // Create the AssigmentParking
        AssigmentParkingDTO assigmentParkingDTO = assigmentParkingMapper.toDto(assigmentParking);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAssigmentParkingMockMvc.perform(put("/api/assigment-parkings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(assigmentParkingDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AssigmentParking in the database
        List<AssigmentParking> assigmentParkingList = assigmentParkingRepository.findAll();
        assertThat(assigmentParkingList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAssigmentParking() throws Exception {
        // Initialize the database
        assigmentParkingRepository.saveAndFlush(assigmentParking);

        int databaseSizeBeforeDelete = assigmentParkingRepository.findAll().size();

        // Get the assigmentParking
        restAssigmentParkingMockMvc.perform(delete("/api/assigment-parkings/{id}", assigmentParking.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<AssigmentParking> assigmentParkingList = assigmentParkingRepository.findAll();
        assertThat(assigmentParkingList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AssigmentParking.class);
        AssigmentParking assigmentParking1 = new AssigmentParking();
        assigmentParking1.setId(1L);
        AssigmentParking assigmentParking2 = new AssigmentParking();
        assigmentParking2.setId(assigmentParking1.getId());
        assertThat(assigmentParking1).isEqualTo(assigmentParking2);
        assigmentParking2.setId(2L);
        assertThat(assigmentParking1).isNotEqualTo(assigmentParking2);
        assigmentParking1.setId(null);
        assertThat(assigmentParking1).isNotEqualTo(assigmentParking2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AssigmentParkingDTO.class);
        AssigmentParkingDTO assigmentParkingDTO1 = new AssigmentParkingDTO();
        assigmentParkingDTO1.setId(1L);
        AssigmentParkingDTO assigmentParkingDTO2 = new AssigmentParkingDTO();
        assertThat(assigmentParkingDTO1).isNotEqualTo(assigmentParkingDTO2);
        assigmentParkingDTO2.setId(assigmentParkingDTO1.getId());
        assertThat(assigmentParkingDTO1).isEqualTo(assigmentParkingDTO2);
        assigmentParkingDTO2.setId(2L);
        assertThat(assigmentParkingDTO1).isNotEqualTo(assigmentParkingDTO2);
        assigmentParkingDTO1.setId(null);
        assertThat(assigmentParkingDTO1).isNotEqualTo(assigmentParkingDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(assigmentParkingMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(assigmentParkingMapper.fromId(null)).isNull();
    }
}
