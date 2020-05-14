package com.it.contrader.web.rest;

import com.it.contrader.BillbillApp;

import com.it.contrader.domain.AssignmentB;
import com.it.contrader.repository.AssignmentBRepository;
import com.it.contrader.service.AssignmentBService;
import com.it.contrader.service.dto.AssignmentBDTO;
import com.it.contrader.service.mapper.AssignmentBMapper;
import com.it.contrader.web.rest.errors.ExceptionTranslator;

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


import static com.it.contrader.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the AssignmentBResource REST controller.
 *
 * @see AssignmentBResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BillbillApp.class)
public class AssignmentBResourceIntTest {

    private static final Instant DEFAULT_ENTRY_DATE_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_ENTRY_DATE_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CAR = 1L;
    private static final Long UPDATED_CAR = 2L;

    private static final Long DEFAULT_PARKPLACE = 1L;
    private static final Long UPDATED_PARKPLACE = 2L;

    @Autowired
    private AssignmentBRepository assignmentBRepository;

    @Autowired
    private AssignmentBMapper assignmentBMapper;
    
    @Autowired
    private AssignmentBService assignmentBService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restAssignmentBMockMvc;

    private AssignmentB assignmentB;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final AssignmentBResource assignmentBResource = new AssignmentBResource(assignmentBService);
        this.restAssignmentBMockMvc = MockMvcBuilders.standaloneSetup(assignmentBResource)
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
    public static AssignmentB createEntity(EntityManager em) {
        AssignmentB assignmentB = new AssignmentB()
            .entryDateTime(DEFAULT_ENTRY_DATE_TIME)
            .car(DEFAULT_CAR)
            .parkplace(DEFAULT_PARKPLACE);
        return assignmentB;
    }

    @Before
    public void initTest() {
        assignmentB = createEntity(em);
    }

    @Test
    @Transactional
    public void createAssignmentB() throws Exception {
        int databaseSizeBeforeCreate = assignmentBRepository.findAll().size();

        // Create the AssignmentB
        AssignmentBDTO assignmentBDTO = assignmentBMapper.toDto(assignmentB);
        restAssignmentBMockMvc.perform(post("/api/assignment-bs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(assignmentBDTO)))
            .andExpect(status().isCreated());

        // Validate the AssignmentB in the database
        List<AssignmentB> assignmentBList = assignmentBRepository.findAll();
        assertThat(assignmentBList).hasSize(databaseSizeBeforeCreate + 1);
        AssignmentB testAssignmentB = assignmentBList.get(assignmentBList.size() - 1);
        assertThat(testAssignmentB.getEntryDateTime()).isEqualTo(DEFAULT_ENTRY_DATE_TIME);
        assertThat(testAssignmentB.getCar()).isEqualTo(DEFAULT_CAR);
        assertThat(testAssignmentB.getParkplace()).isEqualTo(DEFAULT_PARKPLACE);
    }

    @Test
    @Transactional
    public void createAssignmentBWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = assignmentBRepository.findAll().size();

        // Create the AssignmentB with an existing ID
        assignmentB.setId(1L);
        AssignmentBDTO assignmentBDTO = assignmentBMapper.toDto(assignmentB);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAssignmentBMockMvc.perform(post("/api/assignment-bs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(assignmentBDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AssignmentB in the database
        List<AssignmentB> assignmentBList = assignmentBRepository.findAll();
        assertThat(assignmentBList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllAssignmentBS() throws Exception {
        // Initialize the database
        assignmentBRepository.saveAndFlush(assignmentB);

        // Get all the assignmentBList
        restAssignmentBMockMvc.perform(get("/api/assignment-bs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(assignmentB.getId().intValue())))
            .andExpect(jsonPath("$.[*].entryDateTime").value(hasItem(DEFAULT_ENTRY_DATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].car").value(hasItem(DEFAULT_CAR.intValue())))
            .andExpect(jsonPath("$.[*].parkplace").value(hasItem(DEFAULT_PARKPLACE.intValue())));
    }
    
    @Test
    @Transactional
    public void getAssignmentB() throws Exception {
        // Initialize the database
        assignmentBRepository.saveAndFlush(assignmentB);

        // Get the assignmentB
        restAssignmentBMockMvc.perform(get("/api/assignment-bs/{id}", assignmentB.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(assignmentB.getId().intValue()))
            .andExpect(jsonPath("$.entryDateTime").value(DEFAULT_ENTRY_DATE_TIME.toString()))
            .andExpect(jsonPath("$.car").value(DEFAULT_CAR.intValue()))
            .andExpect(jsonPath("$.parkplace").value(DEFAULT_PARKPLACE.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingAssignmentB() throws Exception {
        // Get the assignmentB
        restAssignmentBMockMvc.perform(get("/api/assignment-bs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAssignmentB() throws Exception {
        // Initialize the database
        assignmentBRepository.saveAndFlush(assignmentB);

        int databaseSizeBeforeUpdate = assignmentBRepository.findAll().size();

        // Update the assignmentB
        AssignmentB updatedAssignmentB = assignmentBRepository.findById(assignmentB.getId()).get();
        // Disconnect from session so that the updates on updatedAssignmentB are not directly saved in db
        em.detach(updatedAssignmentB);
        updatedAssignmentB
            .entryDateTime(UPDATED_ENTRY_DATE_TIME)
            .car(UPDATED_CAR)
            .parkplace(UPDATED_PARKPLACE);
        AssignmentBDTO assignmentBDTO = assignmentBMapper.toDto(updatedAssignmentB);

        restAssignmentBMockMvc.perform(put("/api/assignment-bs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(assignmentBDTO)))
            .andExpect(status().isOk());

        // Validate the AssignmentB in the database
        List<AssignmentB> assignmentBList = assignmentBRepository.findAll();
        assertThat(assignmentBList).hasSize(databaseSizeBeforeUpdate);
        AssignmentB testAssignmentB = assignmentBList.get(assignmentBList.size() - 1);
        assertThat(testAssignmentB.getEntryDateTime()).isEqualTo(UPDATED_ENTRY_DATE_TIME);
        assertThat(testAssignmentB.getCar()).isEqualTo(UPDATED_CAR);
        assertThat(testAssignmentB.getParkplace()).isEqualTo(UPDATED_PARKPLACE);
    }

    @Test
    @Transactional
    public void updateNonExistingAssignmentB() throws Exception {
        int databaseSizeBeforeUpdate = assignmentBRepository.findAll().size();

        // Create the AssignmentB
        AssignmentBDTO assignmentBDTO = assignmentBMapper.toDto(assignmentB);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAssignmentBMockMvc.perform(put("/api/assignment-bs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(assignmentBDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AssignmentB in the database
        List<AssignmentB> assignmentBList = assignmentBRepository.findAll();
        assertThat(assignmentBList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAssignmentB() throws Exception {
        // Initialize the database
        assignmentBRepository.saveAndFlush(assignmentB);

        int databaseSizeBeforeDelete = assignmentBRepository.findAll().size();

        // Get the assignmentB
        restAssignmentBMockMvc.perform(delete("/api/assignment-bs/{id}", assignmentB.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<AssignmentB> assignmentBList = assignmentBRepository.findAll();
        assertThat(assignmentBList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AssignmentB.class);
        AssignmentB assignmentB1 = new AssignmentB();
        assignmentB1.setId(1L);
        AssignmentB assignmentB2 = new AssignmentB();
        assignmentB2.setId(assignmentB1.getId());
        assertThat(assignmentB1).isEqualTo(assignmentB2);
        assignmentB2.setId(2L);
        assertThat(assignmentB1).isNotEqualTo(assignmentB2);
        assignmentB1.setId(null);
        assertThat(assignmentB1).isNotEqualTo(assignmentB2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AssignmentBDTO.class);
        AssignmentBDTO assignmentBDTO1 = new AssignmentBDTO();
        assignmentBDTO1.setId(1L);
        AssignmentBDTO assignmentBDTO2 = new AssignmentBDTO();
        assertThat(assignmentBDTO1).isNotEqualTo(assignmentBDTO2);
        assignmentBDTO2.setId(assignmentBDTO1.getId());
        assertThat(assignmentBDTO1).isEqualTo(assignmentBDTO2);
        assignmentBDTO2.setId(2L);
        assertThat(assignmentBDTO1).isNotEqualTo(assignmentBDTO2);
        assignmentBDTO1.setId(null);
        assertThat(assignmentBDTO1).isNotEqualTo(assignmentBDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(assignmentBMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(assignmentBMapper.fromId(null)).isNull();
    }
}
