joo.loadModule("${project.groupId}", "${project.artifactId}");
joo.loadStyleSheet("coredining-theme/css/coredining-doctype-icons.css")
coremediaEditorPlugins.push({
  name:"CoreDining Studio Plugin",
  mainClass:"com.coremedia.coredining.studio.CoreDiningStudioPlugin"
});