package devops

/**
 * List catalogs
 */
def ls() {
    println("List catalogs")
}

/**
 * Add a catalog
 *  添加商店：
 *  url: https://rancher_url/v3/projectcatalog
 *  method:POST
 *  request payload：
 *  {
 *  "type": "projectcatalog",
 *  "kind": "helm",
 *  "branch": "master",
 *  "projectId": "c-92nlp:p-jr7r6",
 *  "helmVersion": "helm_v3",
 *  "name": "testcharts",
 *  "url": "https://github.com/yedward/testcharts.git",
 *  "username": "admin",
 *  "password": "admin888"
 *  }
 */
// project_id
// project_catalog_name
// project_catalog_url
// project_catalog_branch
// project_catalog_username
// project_catalog_password
def add(String projectId, String name, String url, String branch, String username, String password) {
    println("---------------【添加Git仓库地址到应用商店】开始--------------")
    Utils helper = new Utils()
    String requestBody = """
     {
     "type": "projectcatalog",
     "kind": "helm",
     "branch": "${branch}",
     "projectId": "${projectId}",
     "helmVersion": "helm_v3",
     "name": "${name}",
     "url": "${url}",
     "username": "${username}",
     "password": "${password}"
     }
"""
    helper.handleRequest("POST","projectcatalog", "${requestBody}")
    println("---------------【添加Git仓库地址到应用商店】结束--------------")
}

/**
 * Delete a catalog
 */
def delete() {
    println("Delete a catalog")
}

/**
 * Refresh catalog templates
 */
def refresh() {
    println("Refresh catalog templates")
}