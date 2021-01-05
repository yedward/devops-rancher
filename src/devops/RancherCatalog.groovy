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
 *  url: https://rancher_api_url/v3/projectcatalog
 *  method:POST
 *  request payload：
 *  {
 *  "type": "projectcatalog",
 *  "kind": "helm",
 *  "branch": "your_branch",
 *  "projectId": "your_project_id",
 *  "helmVersion": "helm_v3",
 *  "name": "your_catalog_name",
 *  "url": "https://github.com/xxxx/xxxx.git",
 *  "username": "your_username",
 *  "password": "your_password"
 *  }
 */
def add(String projectId, String name, String url, String branch, String username, String password) {
    println("---------------【添加Git仓库地址到应用商店】开始--------------")
    Application application = new Application()
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
    application.handleRequest("POST","projectcatalog", "${requestBody}")
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