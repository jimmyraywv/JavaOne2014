package org.jimmyray.services;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jimmyray.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(Constants.SYSTEM_INFO_SERVICE_BEAN_NAME)
public class SystemInfoServiceImpl implements SystemInfoService {
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SystemInfoServiceImpl.class);

	@Override
	public Map<String, Object> getSystemInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy.MM.dd G 'at' HH:mm:ss z");

		RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();

		List<String> jvmArgs = runtimeMxBean.getInputArguments();
		Map<String, String> systemProperties = runtimeMxBean
				.getSystemProperties();

		Map<String, String> otherProperties = new HashMap<String, String>();
		otherProperties.put("Boot ClassPath", runtimeMxBean.getBootClassPath());
		otherProperties.put("ClassPath", runtimeMxBean.getClassPath());
		otherProperties.put("Library Path", runtimeMxBean.getLibraryPath());
		otherProperties.put("Management Spec Version",
				runtimeMxBean.getManagementSpecVersion());
		otherProperties.put("Name", runtimeMxBean.getName());
		otherProperties.put("Spec Name", runtimeMxBean.getSpecName());
		otherProperties.put("Spec Vendor", runtimeMxBean.getSpecVendor());
		otherProperties.put("Spec Version", runtimeMxBean.getSpecVersion());
		otherProperties.put("Vm Name", runtimeMxBean.getVmName());
		otherProperties.put("VM Vendor", runtimeMxBean.getVmVendor());
		otherProperties.put("Spec Version", runtimeMxBean.getVmVersion());
		otherProperties.put("Start Time",
				sdf.format(new Date(runtimeMxBean.getStartTime())));

		LOGGER.debug(jvmArgs.toString());
		LOGGER.debug(systemProperties.toString());
		LOGGER.debug(otherProperties.toString());

		Map<String, Object> result = new HashMap<String, Object>();
		result.put(Constants.JVM_ARGS, jvmArgs);
		result.put(Constants.SYSTEM_PROPS, systemProperties);
		result.put(Constants.OTHER_PROPS, otherProperties);
		
		return result;
	}

}
