package com.intellij.tapestry.tests.core.util;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.actionSystem.ex.DataConstantsEx;
import com.intellij.tapestry.intellij.util.IdeaUtils;
import com.intellij.tapestry.tests.core.BaseTestCase;
import com.intellij.testFramework.fixtures.IdeaProjectTestFixture;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Nullable;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class IdeaUtilsTest extends BaseTestCase {

    @BeforeClass
    public void defaultConstructor() {
        new IdeaUtils();
    }

    @Test(dataProvider = JAVA_MODULE_FIXTURE_PROVIDER)
    public void isModuleNode(IdeaProjectTestFixture fixture) {
        MapDataContext dataContext = new MapDataContext();
        dataContext.put(DataConstantsEx.PROJECT, fixture.getProject());
        dataContext.put(DataConstantsEx.MODULE_CONTEXT, fixture.getModule());

        AnActionEvent actionEvent = new AnActionEvent(null, dataContext, "", new Presentation(), null, 0);
        assert IdeaUtils.isModuleNode(actionEvent);


        dataContext.put(DataConstantsEx.PROJECT, null);
        dataContext.put(DataConstantsEx.MODULE_CONTEXT, null);

        actionEvent = new AnActionEvent(null, dataContext, "", new Presentation(), null, 0);
        assert !IdeaUtils.isModuleNode(actionEvent);
    }

    static class MapDataContext extends HashMap implements DataContext {

        @Nullable
        public Object getData(@NonNls String dataId) {
            return get(dataId);
        }
    }
}
