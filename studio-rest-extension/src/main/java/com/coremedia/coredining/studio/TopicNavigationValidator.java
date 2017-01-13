//package com.coremedia.coredining.studio;
//
//import com.coremedia.cap.content.Content;
//import com.coremedia.rest.cap.validation.ContentTypeValidatorBase;
//import com.coremedia.rest.validation.Issues;
//import com.coremedia.rest.validation.Severity;
//
//import java.util.HashSet;
//import java.util.List;
//
//public class TopicNavigationValidator extends ContentTypeValidatorBase {
//
//  private static final String TYPE_TOPIC = "Topic";
//
//  private static final String PROPERTY_SUBTOPICS = "subTopics";
//  private static final String PROPERTY_TITLE = "title";
//
//  private static final String CODE_NO_TITLE = "noTitle";
//  private static final String CODE_SAME_TITLE_TWICE = "sameTitleTwice";
//  private static final String CODE_SIBLING_WITH_SAME_TITLE = "siblingWithSameTitle";
//
//  @Override
//  public void validate(Content content, Issues issues) {
//    validateSubTopics(content, issues);
//    validateTitle(content, issues);
//  }
//
//  private void validateSubTopics(Content topic, Issues issues) {
//    List<Content> subTopics = topic.getLinks(PROPERTY_SUBTOPICS);
//    HashSet<String> set = new HashSet<>();
//
//    for (Content subTopic : subTopics) {
//      String title = subTopic.getString(PROPERTY_TITLE);
//      if (title == null || title.isEmpty()) {
//        issues.addIssue(Severity.ERROR, CODE_NO_TITLE, subTopic.getPath(), subTopic);
//      } else if (set.contains(title)) {
//        issues.addIssue(Severity.ERROR, CODE_SAME_TITLE_TWICE, subTopic.getPath(), subTopic);
//      } else {
//        set.add(title);
//      }
//    }
//
//    /* TODO: validate the subTopics of this topic.
//     *
//     * - Every subTopic should have a title property, otherwise add an issue of
//     *   type ERROR with code "noTitle", property "subTopics" and the path to the
//     *   invalid topic as parameter.
//     *
//     * - Every subTopic must have a unique title, otherwise add an issue of type
//     *   ERROR with code "sameTitleTwice" and the title as parameter.
//     *
//     * HINT:
//     * iterate the subTopics link list and use a Set to check for dublicates. if the
//     * title of the current subTopic is already stored in the Set, create an issue,
//     * otherwise put it to the map and continue.
//     */
//  }
//
//  private void validateTitle(Content topic, Issues issues) {
//    /* TODO: validate that the title of this topic is not used by another sibling.
//     *
//     * Use "siblingWithSameTitle" as issue code. and ERROR as severity.
//     *
//     * HINT:
//     * Find the parent topics by calling getReferrersWithDescriptor("Topic", "subTopics");
//     * Then iterate the subtopics of the parent topics and verify that there is no other
//     * sibling with the same title.
//     */
//  }
//}
