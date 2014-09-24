package org.jimmyray.config;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

/**
 * Base tests for all eag web application spring integrated unit tests
 *
 * @author jshrader
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners( listeners = { DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class })
@ContextConfiguration(inheritLocations = false, classes = { TestWebConfig.class })
public abstract class AbstractSpringIntegratedWebTest {

}