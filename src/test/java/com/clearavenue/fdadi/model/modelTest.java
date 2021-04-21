package com.clearavenue.fdadi.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
public class modelTest {

	@Test
	void pharmClass() {
		final String name = "NAME";
		final var obj = PharmClass.builder().pharmClassName("name").build();
		assertThat(name).isEqualTo(obj.getPharmClassName());
	}

	@Test
	void medication() {
		final String name = "NAME";
		final var obj = Medication.builder().medicationName("name").build();
		assertThat(name).isEqualTo(obj.getMedicationName());
	}

	@Test
	void medicationCompare() {
		final var obj1 = Medication.builder().medicationName("name").build();
		final var obj2 = Medication.builder().medicationName("name").build();
		final int result = obj1.compareTo(obj2);
		assertThat(result).isEqualTo(0);
	}

	@Test
	void labelResults() {
		final var obj = new LabelResults();
		obj.setActiveIngredient(List.of("ingrediant1"));
		obj.setAdverseReactions(List.of("advR1"));
		obj.setAdverseReactionsTable(List.of("advReactions"));
		obj.setAnimalPharmacologyAndOrToxicology(List.of("none"));
		obj.setAskDoctor(List.of("none"));
		obj.setAskDoctorOrPharmacist(List.of("none"));
		obj.setCarcinogenesisAndMutagenesisAndImpairmentOfFertility(List.of("none"));
		obj.setClinicalPharmacology(List.of("none"));
		obj.setClinicalPharmacologyTable(List.of("none"));
		obj.setClinicalStudies(List.of("none"));
		obj.setClinicalStudiesTable(List.of("none"));
		obj.setContraindications(List.of("none"));
		obj.setDescription(List.of("none"));
		obj.setDoNotUse(List.of("none"));
		obj.setDosageAndAdministration(List.of("none"));
		obj.setDosageFormsAndStrengths(List.of("none"));
		obj.setDrugInteractions(List.of("none"));
		obj.setEffectiveTime("time");
		obj.setGeriatricUse(List.of("none"));
		obj.setHowSupplied(List.of("none"));
		obj.setHowSuppliedTable(List.of("none"));
		obj.setId("id");
		obj.setInactiveIngredient(List.of("none"));
		obj.setIndicationsAndUsage(List.of("none"));
		obj.setInformationForPatients(List.of("none"));
		obj.setKeepOutOfReachOfChildren(List.of("none"));
		obj.setMechanismOfAction(List.of("none"));
		obj.setNonclinicalToxicology(List.of("none"));
		obj.setNursingMothers(List.of("none"));
		obj.setOpenfda(null);
		obj.setOtherSafetyInformation(List.of("none"));
		obj.setOverdosage(List.of("none"));
		obj.setPackageLabelPrincipalDisplayPanel(List.of("none"));
		obj.setPediatricUse(List.of("none"));
		obj.setPharmacodynamics(List.of("none"));
		obj.setPharmacodynamicsTable(List.of("none"));
		obj.setPharmacokinetics(List.of("none"));
		obj.setPregnancy(List.of("none"));
		obj.setPregnancyOrBreastFeeding(List.of("none"));
		obj.setPurpose(List.of("none"));
		obj.setQuestions(List.of("none"));
		obj.setRecentMajorChanges(List.of("none"));
		obj.setRecentMajorChangesTable(List.of("none"));
		obj.setSetId("id");
		obj.setSplPatientPackageInsert(List.of("none"));
		obj.setSplProductDataElements(List.of("none"));
		obj.setSplUnclassifiedSection(List.of("none"));
		obj.setSplUnclassifiedSectionTable(List.of("none"));
		obj.setStopUse(List.of("none"));
		obj.setStorageAndHandling(List.of("none"));
		obj.setTeratogenicEffects(List.of("none"));
		obj.setUseInSpecificPopulations(List.of("none"));
		obj.setVersion("version");
		obj.setWarnings(List.of("none"));
		obj.setWarningsAndCautions(List.of("none"));
		assertThat(obj).isEqualTo(obj);
	}

	@Test
	void recallResults() {
		final var obj = new RecallResults();
		obj.setAddress1("none");
		obj.setAddress2("none");
		obj.setCenterClassificationDate("none");
		obj.setCity("none");
		obj.setClassification("none");
		obj.setCodeInfo("none");
		obj.setCountry("none");
		obj.setDistributionPattern("none");
		obj.setEventId("none");
		obj.setInitialFirmNotification("none");
		obj.setMoreCodeInfo(null);
		obj.setOpenfda(null);
		obj.setPostalCode("none");
		obj.setProductDescription("none");
		obj.setProductQuantity("none");
		obj.setProductType("none");
		obj.setReasonForRecall("none");
		obj.setRecallingFirm("none");
		obj.setRecallInitiationDate("none");
		obj.setRecallNumber("none");
		obj.setReportDate("none");
		obj.setState("none");
		obj.setStatus("none");
		obj.setTerminationDate("none");
		obj.setVoluntaryMandated("none");
	}

	@Test
	void recallOpenfda() {
		final var obj = new RecallOpenfda();
		obj.setApplicationNumber(List.of("none"));
		obj.setBrandName(List.of("none"));
		obj.setGenericName(List.of("none"));
		obj.setIsOriginalPackager(List.of(false));
		obj.setManufacturerName(List.of("none"));
		obj.setNui(List.of("none"));
		obj.setOriginalPackagerProductNdc(List.of("none"));
		obj.setPackageNdc(List.of("none"));
		obj.setPharmClassCs(List.of("none"));
		obj.setPharmClassEpc(List.of("none"));
		obj.setPharmClassMoa(List.of("none"));
		obj.setPharmClassPe(List.of("none"));
		obj.setProductNdc(List.of("none"));
		obj.setProductType(List.of("none"));
		obj.setRoute(List.of("none"));
		obj.setRxcui(List.of("none"));
		obj.setSplId(List.of("none"));
		obj.setSplSetId(List.of("none"));
		obj.setSubstanceName(List.of("none"));
		obj.setUnii(List.of("none"));
		obj.setUpc(List.of("none"));
	}

	@Test
	void labelOpenfda() {
		final var obj = new LabelOpenfda();
		obj.setApplicationNumber(List.of("none"));
		obj.setBrandName(List.of("none"));
		obj.setGenericName(List.of("none"));
		obj.setIsOriginalPackager(List.of(false));
		obj.setManufacturerName(List.of("none"));
		obj.setNui(List.of("none"));
		obj.setPackageNdc(List.of("none"));
		obj.setPharmClassCs(List.of("none"));
		obj.setPharmClassEpc(List.of("none"));
		obj.setPharmClassMoa(List.of("none"));
		obj.setPharmClassPe(List.of("none"));
		obj.setProductNdc(List.of("none"));
		obj.setProductType(List.of("none"));
		obj.setRoute(List.of("none"));
		obj.setRxcui(List.of("none"));
		obj.setSplId(List.of("none"));
		obj.setSplSetId(List.of("none"));
		obj.setSubstanceName(List.of("none"));
		obj.setUnii(List.of("none"));
		obj.setUpc(List.of("none"));
	}

	@Test
	void meta() {
		final var obj = new Meta();
		obj.setDisclaimer("none");
		obj.setLastUpdated("none");
		obj.setLicense("none");
		obj.setResults(null);
		obj.setTerms("none");
	}

	@Test
	void metaResults() {
		final var obj = new MetaResults();
		obj.setLimit(10);
		obj.setSkip(1);
		obj.setTotal(10);
	}

	@Test
	void labelResult() {
		final var obj = new LabelResult();
		obj.setMeta(null);
		obj.setResults(null);
	}

	@Test

	void recallResult() {
		final var obj = new RecallResult();
		obj.setMeta(null);
		obj.setResults(null);
	}
}
