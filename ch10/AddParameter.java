package ch10;


/* 
 * A method need more information from its caller
 * 
 * Add a parameter for an object that can pass on this information
 * 
 * - Often you have other alternative to adding a parameter. If available, these
 *   alternatives are better because they don't leading to increasing the length of
 *   parameter lists
 * 
 * - Ask these question before adding parameters:
 *   1. Can you ask one of those objects for the information you need?
 *      If not, would it make sense to give them a method to provide that information
 *   2. What are you using the information for?
 *   3. Should that behavior be on another object, the one that has the information?
 */
