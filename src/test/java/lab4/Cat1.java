package lab4;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(Cat1.class)
@Suite.SuiteClasses({jetpacktravelTest.class, myshowsTest.class, myshowsprofileTest.class})
public class Cat1 {

}
