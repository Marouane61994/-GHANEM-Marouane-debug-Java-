package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Writes all treated data on a file
 */
public interface ISymptomWriter {
    /**
     * Write paramétre symptome et quantité
     *
     * @param symptoms the map of sorted data
     */
    void writeSymptoms(Map<String, Integer> symptoms);

}