package it.contrader.com.web.rest;

import it.contrader.com.BillApp;

import it.contrader.com.domain.AssignmentParking;
import it.contrader.com.repository.AssignmentParkingRepository;
import it.contrader.com.service.AssignmentParkingService;
import it.contrader.com.service.dto.AssignmentParkingDTO;
import it.contrader.com.service.mapper.AssignmentParkingMapper;
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
 * Test class for the AssignmentParkingResource REST controller.
 *
 * @see AssignmentParkingResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BillApp.class)
public class AssignmentParkingResourceIntTest {

    private static final Long DEFAULT_CAR = 1L;
    private static final Long UPDATED_CAR = 2L;

    private static final Long DEFAULT_PARKINGPLACE = 1L;
    private static final Long UPDATED_PARKINGPLACE = 2L;

    private static final Instant DEFAULT_ENTRY_DATE_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_ENTRY_DATE_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private AssignmentParkingRepository assignmentParkingRepository;

    @Autowired
    private AssignmentParkingMapper assignmentParkingMapper;
    
    @Autowired
    private AssignmentParkingService assignmentParkingService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restAssignmentParkingMockMvc;

    private AssignmentParking assignmentParking;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final AssignmentParkingResource assignmentParkingResource = new AssignmentParkingResource(assignmentParkingService);
        this.restAssignmentParkingMockMvc = MockMvcBuilders.standaloneSetup(assignmentParkingResource)
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
    public static AssignmentParking createEntity(EntityManager em) {
        AssignmentParking assignmentParking = new AssignmentParking()
            .car(DEFAULT_CAR)
            .parkingplace(DEFAULT_PARKINGPLACE)
            .entryDateTime(DEFAULT_ENTRY_DATE_TIME);
        return assignmentParking;
    }

    @Before
    public void initTest() {
        assignmentParking = createEntity(em);
    }

    @Test
    @Transactional
    public void createAssignmentParking() throws Exception {
        int databaseSizeBeforeCreate = assignmentParkingRepository.findAll().size();

        // Create the AssignmentParking
        AssignmentParkingDTO assignmentParkingDTO = assignmentParkingMapper.toDto(assignmentParking);
        restAssignmentParkingMockMvc.perform(post("/api/assignment-parkings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(assignmentParkingDTO)))
            .andExpect(status().isCreated());

        // Validate the AssignmentParking in the database
        List<AssignmentParking> assignmentParkingList = assignmentParkingRepository.findAll();
        assertThat(assignmentParkingList).hasSize(databaseSizeBeforeCreate + 1);
        AssignmentParking testAssignmentParking = assignmentParkingList.get(assignmentParkingList.size() - 1);
        assertThat(testAssignmentParking.getCar()).isEqualTo(DEFAULT_CAR);
        assertThat(testAssignmentParking.getParkingplace()).isEqualTo(DEFAULT_PARKINGPLACE);
        assertThat(testAssignmentParking.getEntryDateTime()).isEqualTo(DEFAULT_ENTRY_DATE_TIME);
    }

    @Test
    @Transactional
    public void createAssignmentParkingWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = assignmentParkingRepository.findAll().size();

        // Create the AssignmentParking with an existing ID
        assignmentParking.setId(1L);
        AssignmentParkingDTO assignmentParkingDTO = assignmentParkingMapper.toDto(assignmentParking);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAssignmentParkingMockMvc.perform(post("/api/assignment-parkings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(assignmentParkingDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AssignmentParking in the database
        List<AssignmentParking> assignmentParkingList = assignmentParkingRepository.findAll();
        assertThat(assignmentParkingList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllAssignmentParkings() throws Exception {
        // Initialize the database
        assignmentParkingRepository.saveAndFlush(assignmentParking);

        // Get all the assignmentParkingList
        restAssignmentParkingMockMvc.perform(get("/api/assignment-parkings?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(assignmentParking.getId().intValue())))
            .andExpect(jsonPath("$.[*].car").value(hasItem(DEFAULT_CAR.intValue())))
            .andExpect(jsonPath("$.[*].parkingplace").value(hasItem(DEFAULT_PARKINGPLACE.intValue())))
            .andExpect(jsonPath("$.[*].entryDateTime").value(hasItem(DEFAULT_ENTRY_DATE_TIME.toString())));
    }
    
    @Test
    @Transactional
    public void getAssignmentParking() throws Exception {
        // Initialize the database
        assignmentParkingRepository.saveAndFlush(assignmentParking);

        // Get the assignmentParking
        restAssignmentParkingMockMvc.perform(get("/api/assignment-parkings/{id}", assignmentParking.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(assignmentParking.getId().intValue()))
            .andExpect(jsonPath("$.car").value(DEFAULT_CAR.intValue()))
            .andExpect(jsonPath("$.parkingplace").value(DEFAULT_PARKINGPLACE.intValue()))
            .andExpect(jsonPath("$.entryDateTime").value(DEFAULT_ENTRY_DATE_TIME.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingAssignmentParking() throws Exception {
        // Get the assignmentParking
        restAssignmentParkingMockMvc.perform(get("/api/assignment-parkings/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAssignmentParking() throws Exception {
        // Initialize the database
        assignmentParkingRepository.saveAndFlush(assignmentParking);

        int databaseSizeBeforeUpdate = assignmentParkingRepository.findAll().size();

        // Update the assignmentParking
        AssignmentParking updatedAssignmentParking = assignmentParkingRepository.findById(assignmentParking.getId()).get();
        // Disconnect from session so that the updates on updatedAssignmentParking are not directly saved in db
        em.detach(updatedAssignmentParking);
        updatedAssignmentParking
            .car(UPDATED_CAR)
            .parkingplace(UPDATED_PARKINGPLACE)
            .entryDateTime(UPDATED_ENTRY_DATE_TIME);
        AssignmentParkingDTO assignmentParkingDTO = assignmentParkingMapper.toDto(updatedAssignmentParking);

        restAssignmentParkingMockMvc.perform(put("/api/assignment-parkings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(assignmentParkingDTO)))
            .andExpect(status().isOk());

        // Validate the AssignmentParking in the database
        List<AssignmentParking> assignmentParkingList = assignmentParkingRepository.findAll();
        assertThat(assignmentParkingList).hasSize(databaseSizeBeforeUpdate);
        AssignmentParking testAssignmentParking = assignmentParkingList.get(assignmentParkingList.size() - 1);
        assertThat(testAssignmentParking.getCar()).isEqualTo(UPDATED_CAR);
        assertThat(testAssignmentParking.getParkingplace()).isEqualTo(UPDATED_PARKINGPLACE);
        assertThat(testAssignmentParking.getEntryDateTime()).isEqualTo(UPDATED_ENTRY_DATE_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingAssignmentParking() throws Exception {
        int databaseSizeBeforeUpdate = assignmentParkingRepository.findAll().size();

        // Create the AssignmentParking
        AssignmentParkingDTO assignmentParkingDTO = assignmentParkingMapper.toDto(assignmentParking);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAssignmentParkingMockMvc.perform(put("/api/assignment-parkings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(assignmentParkingDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AssignmentParking in the database
        List<AssignmentParking> assignmentParkingList = assignmentParkingRepository.findAll();
        assertThat(assignmentParkingList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAssignmentParking() throws Exception {
        // Initialize the database
        assignmentParkingRepository.saveAndFlush(assignmentParking);

        int databaseSizeBeforeDelete = assignmentParkingRepository.findAll().size();

        // Get the assignmentParking
        restAssignmentParkingMockMvc.perform(delete("/api/assignment-parkings/{id}", assignmentParking.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<AssignmentParking> assignmentParkingList = assignmentParkingRepository.findAll();
        assertThat(assignmentParkingList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AssignmentParking.class);
        AssignmentParking assignmentParking1 = new AssignmentParking();
        assignmentParking1.setId(1L);
        AssignmentParking assignmentParking2 = new AssignmentParking();
        assignmentParking2.setId(assignmentParking1.getId());
        assertThat(assignmentParking1).isEqualTo(assignmentParking2);
        assignmentParking2.setId(2L);
        assertThat(assignmentParking1).isNotEqualTo(assignmentParking2);
        assignmentParking1.setId(null);
        assertThat(assignmentParking1).isNotEqualTo(assignmentParking2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AssignmentParkingDTO.class);
        AssignmentParkingDTO assignmentParkingDTO1 = new AssignmentParkingDTO();
        assignmentParkingDTO1.setId(1L);
        AssignmentParkingDTO assignmentParkingDTO2 = new AssignmentParkingDTO();
        assertThat(assignmentParkingDTO1).isNotEqualTo(assignmentParkingDTO2);
        assignmentParkingDTO2.setId(assignmentParkingDTO1.getId());
        assertThat(assignmentParkingDTO1).isEqualTo(assignmentParkingDTO2);
        assignmentParkingDTO2.setId(2L);
        assertThat(assignmentParkingDTO1).isNotEqualTo(assignmentParkingDTO2);
        assignmentParkingDTO1.setId(null);
        assertThat(assignmentParkingDTO1).isNotEqualTo(assignmentParkingDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(assignmentParkingMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(assignmentParkingMapper.fromId(null)).isNull();
    }
}
