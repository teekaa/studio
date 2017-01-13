package com.coremedia.coredining.studio;

import com.coremedia.cap.Cap;
import com.coremedia.cap.common.CapConnection;
import com.coremedia.cap.common.IdHelper;
import com.coremedia.cap.content.Content;
import org.springframework.beans.factory.annotation.Required;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Produces(MediaType.APPLICATION_JSON)
@Path("referrers")
public class ReferrersResource {

  private CapConnection connection;

  @Required
  public void setConnection(CapConnection connection) {
    this.connection = connection;
  }

  @GET
  @Path("/{id:\\d+}/all")
  public List<Content> getAllReferrers(@PathParam("id") String id) {
    /* TODO: Implement this method...
     * 1. Use the numerical ID to lookup the content from the content repository.
     * 2. Use the getReferrers() method to get all referrers for this content object
     * 3. Return the result as list
     */
    Content content = connection.getContentRepository().getContent(id);
    Set<Content> referrers = content.getReferrers();

    List<Content> liste = new ArrayList<>();
    for (Content referrer : referrers) {
      liste.add(referrer);
    }
    return liste;
  }
}
