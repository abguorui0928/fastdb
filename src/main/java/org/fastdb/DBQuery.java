package org.fastdb;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;

public interface DBQuery {
	/**
	 * Execute a SELECT query and return the query results as an untyped List.
	 *
	 * @return a list of the results
	 *
	 * @throws IllegalStateException if called for a Java Persistence query
	 *             language UPDATE or DELETE statement
	 * @throws PersistenceException if the query execution exceeds the query
	 *             timeout value set and the transaction is rolled back
	 */
	List<DBRow> getResultList();

	/**
	 * Execute a SELECT query that returns a single untyped result.
	 *
	 * @return the result
	 *
	 * @throws NoResultException if there is no result
	 * @throws NonUniqueResultException if more than one result
	 * @throws IllegalStateException if called for a Java Persistence query
	 *             language UPDATE or DELETE statement
	 * @throws PersistenceException if the query execution exceeds the query
	 *             timeout value set and the transaction is rolled back
	 */
	DBRow getSingleResult();

	/**
	 * Execute an update or delete statement.
	 *
	 * @return the number of entities updated or deleted
	 *
	 * @throws IllegalStateException if called for a Java Persistence query
	 *             language SELECT statement or for a criteria query
	 * @throws PersistenceException if the query execution exceeds the query
	 *             timeout value set and the transaction is rolled back
	 */
	int executeUpdate();

	/**
	 * Bind the value of a Parameter object.
	 *
	 * @param param parameter object
	 * @param value parameter value
	 *
	 * @return the same query instance
	 *
	 * @throws IllegalArgumentException if the parameter does not correspond to
	 *             a parameter of the query
	 */
	DBQuery setParameter(int position, Object value);

	/**
	 * Bind an instance of a Parameter object with a given SqlType.
	 *
	 * @param param parameter object
	 * @param value parameter value
	 * @param temporalType temporal type
	 *
	 * @return the same query instance
	 *
	 * @throws IllegalArgumentException if the parameter does not correspond to
	 *             a parameter of the query
	 */
	DBQuery setParameter(int position, Object value, int sqlType);
}
