package com.capgemini.mrchecker.test.core.unit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.parallel.ResourceLock;

import com.capgemini.mrchecker.test.core.BaseTestExecutionObserver;
import com.capgemini.mrchecker.test.core.ITestObserver;
import com.capgemini.mrchecker.test.core.ModuleType;
import com.capgemini.mrchecker.test.core.tags.UnitTest;
import com.capgemini.mrchecker.test.core.utils.FileUtils;

@UnitTest
@ResourceLock(value = "BaseTestExecutionObserver")
public class BaseTestExecutionObserverBaseTest {
	protected static final BaseTestExecutionObserver	SUT	= BaseTestExecutionObserver.getInstance();
	protected static final ExtensionContext				contextMock;
	protected static final ITestObserver				observerMock;
	
	protected static String logFilePath = FileUtils.getLogFilePath();
	
	static {
		contextMock = mock(ExtensionContext.class);
		when(contextMock.getTestClass()).thenReturn(Optional.of(BaseTestExecutionObserverBaseTest.class));
		when(contextMock.getRequiredTestClass()).thenCallRealMethod();
		when(contextMock.getDisplayName()).thenReturn("Test_name");
		
		observerMock = mock(ITestObserver.class);
		when(observerMock.getModuleType()).thenReturn(ModuleType.CORE);
	}
}
