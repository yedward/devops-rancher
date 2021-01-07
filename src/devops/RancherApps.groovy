package devops

/**
 * List apps
 */
def ls() {
    def url = "sdfdsfsdf/sdfsf"
    println("List apps")
}

/**
 * Delete an app
 */
def delete() {
    println("Delete an app")
}

/**
 * 从应用商店部署应用
 *
 * 示例：
 *  url: https://rancher_api_url/v3/projects/your_cluster_project_id/app
 *  method:POST
 *  request payload：
// {
// "prune": false,
// "timeout": 300,
// "wait": false,
// "type": "app",
// "name": "your_app_release_name",
// "answers": {},
// "targetNamespace": "your_namespace",
// "externalId": "catalog://?catalog=your_project_id/your_catalog_name&type=projectCatalog&template=your_catalog_app_name&version=your_catalog_app_version",
// "projectId": "your_cluster_project_id",
// "valuesYaml": "---{}\n"
// }
 */
def install(String clusterProjectId, String projectId, String releaseName, String namespaceName, String catalogName, String catalogAppName, String catalogAppVersion, String valuesYaml) {
    println("---------------【从应用商店部署应用】开始--------------")
    Application application = new Application()
    String requestBody = """
     {
     "prune": false,
     "timeout": 300,
     "wait": false,
     "type": "app",
     "name": "${releaseName}",
     "answers": {},
     "targetNamespace": "${namespaceName}",
     "externalId": "catalog://?catalog=${projectId}/${catalogName}&type=projectCatalog&template${catalogAppName}&version=${catalogAppVersion}",
     "projectId": "${clusterProjectId}",
     "valuesYaml": "${valuesYaml}"
     }
"""
    def response = application.handleRequest("POST","/projects/${clusterProjectId}/app", "${requestBody}")
    println("---------------【从应用商店部署应用】结束--------------")
    return response
}

/**
 * Rollback an app to a previous version
 */
def rollback() {
    println("Rollback an app to a previous version")
}

/**
 * Upgrade an existing app to a newer version
 */
def upgrade() {
    println("Upgrade an existing app to a newer version")
}