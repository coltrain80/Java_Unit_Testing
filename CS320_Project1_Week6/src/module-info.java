/**
 * 
 */
/**
 * @author coltr
 *
 */
module CS320_Project1 {
    requires org.junit.jupiter.api;

    // Use the actual package name where your test classes are located
    opens fillmore_app to org.junit.platform.commons;
}
