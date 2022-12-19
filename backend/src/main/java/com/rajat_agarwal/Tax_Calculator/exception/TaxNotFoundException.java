package com.rajat_agarwal.Tax_Calculator.exception;

public class TaxNotFoundException extends RuntimeException{

    String resourceName;
    String fieldName;
    Long FieldId;
    String fieldNameId;

    public TaxNotFoundException(String resourceName, String fieldName, Long fieldId) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldId));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        FieldId = fieldId;
    }

    public TaxNotFoundException(String resourceName, String fieldName, String fieldNameId) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldNameId));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldNameId = fieldNameId;
    }
}
