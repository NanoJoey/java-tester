package org.jtester.unitils.dbwiki;

import static org.unitils.util.AnnotationUtils.getMethodOrClassLevelAnnotation;
import static org.unitils.util.AnnotationUtils.getMethodOrClassLevelAnnotationProperty;
import static org.unitils.util.ModuleUtils.getAnnotationPropertyDefault;
import static org.unitils.util.ModuleUtils.getAnnotationPropertyDefaults;
import static org.unitils.util.ModuleUtils.getClassValueReplaceDefault;
import static org.unitils.util.ReflectionUtils.createInstanceOfType;
import static org.unitils.util.ReflectionUtils.getClassWithName;

import java.lang.reflect.Method;
import java.util.Properties;

import org.unitils.dbunit.DbUnitModule;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.dbunit.datasetfactory.DataSetFactory;
import org.unitils.dbunit.datasetloadstrategy.DataSetLoadStrategy;
import org.unitils.dbunit.util.MultiSchemaDataSet;

public class WikiDbUnitModule extends DbUnitModule {
	@SuppressWarnings("unchecked")
	public void init(Properties configuration) {
		super.init(configuration);
		defaultAnnotationPropertyValues = getAnnotationPropertyDefaults(WikiDbUnitModule.class, configuration,
				WikiDataSet.class, ExpectedDataSet.class);
	}

	@Override
	public MultiSchemaDataSet getDataSet(Method testMethod, Object testObject) {
		Class<?> testClass = testObject.getClass();
		WikiDataSet wikiDataSetAnnotation = getMethodOrClassLevelAnnotation(WikiDataSet.class, testMethod, testClass);
		if (wikiDataSetAnnotation == null) {
			// No @DataSet annotation found
			return null;
		}

		// Create configured factory for data sets
		DataSetFactory dataSetFactory = getDataSetFactory(WikiDataSet.class, testMethod, testClass);

		// Get the dataset file name
		String[] dataSetFileNames = wikiDataSetAnnotation.value();
		if (dataSetFileNames.length == 0) {
			dataSetFileNames = new String[] { getDefaultDataSetFileName(testClass, dataSetFactory
					.getDataSetFileExtension()) };
		}

		return getDataSet(testClass, dataSetFileNames, dataSetFactory);
	}

	@Override
	protected DataSetFactory getDefaultDataSetFactory() {
		Class<? extends DataSetFactory> dataSetFactoryClass = getClassWithName(getAnnotationPropertyDefault(
				WikiDbUnitModule.class, WikiDataSet.class, "factory", configuration));
		return getDataSetFactory(dataSetFactoryClass);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected DataSetLoadStrategy getDataSetLoadStrategy(Method testMethod, Class testClass) {
		Class<? extends DataSetLoadStrategy> dataSetOperationClass = getMethodOrClassLevelAnnotationProperty(
				WikiDataSet.class, "loadStrategy", DataSetLoadStrategy.class, testMethod, testClass);
		dataSetOperationClass = (Class<? extends DataSetLoadStrategy>) getClassValueReplaceDefault(WikiDataSet.class,
				"loadStrategy", dataSetOperationClass, defaultAnnotationPropertyValues, DataSetLoadStrategy.class);
		return createInstanceOfType(dataSetOperationClass, false);
	}

	@Override
	protected DataSetLoadStrategy getDefaultDataSetLoadStrategy() {
		Class<? extends DataSetLoadStrategy> dataSetLoadStrategyClassName = getClassWithName(getAnnotationPropertyDefault(
				WikiDbUnitModule.class, WikiDataSet.class, "loadStrategy", configuration));
		return createInstanceOfType(dataSetLoadStrategyClassName, false);
	}
}
