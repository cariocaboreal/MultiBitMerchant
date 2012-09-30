package org.multibit.mbm.api.response.hal;

import com.google.common.base.Optional;
import com.theoryinpractise.halbuilder.spi.Resource;
import org.junit.Before;
import org.junit.Test;
import org.multibit.mbm.db.dto.User;
import org.multibit.mbm.db.dto.UserBuilder;
import org.multibit.mbm.test.BaseResourceTest;
import org.multibit.mbm.test.FixtureAsserts;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

public class AdminUserBridgeTest extends BaseResourceTest {

  @Before
  public void setUpDefaultRequestInfo() throws Exception {
    setUpUriInfo(Optional.<String>absent());
    setUpHttpHeaders(Optional.<List<MediaType>>absent());
  }

  @Test
  public void representUserAsJson() throws Exception {

    User user = UserBuilder
      .newInstance()
      .build();

    AdminUserBridge testObject = new AdminUserBridge(uriInfo,principal);

    Resource resource = testObject.toResource(user);

    FixtureAsserts.assertRepresentationMatchesJsonFixture("a User can be marshalled to JSON", resource, "fixtures/hal/user/expected-users-by-admin-page-1.json");

  }

  @Test
  public void representUserAsXml() throws IOException {

    User user = UserBuilder
      .newInstance()
      .build();

    AdminUserBridge testObject = new AdminUserBridge(uriInfo,principal);

    Resource resource = testObject.toResource(user);

    FixtureAsserts.assertRepresentationMatchesXmlFixture("a User can be marshalled to XML", resource, "fixtures/hal/user/expected-user-by-admin.xml");

  }

}