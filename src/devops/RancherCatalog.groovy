package devops

/**
 * List catalogs
 */
def ls() {
    println("List catalogs")
}

/**
 * 根据应用商店名称查询商店信息，可用于判断商店是否已经添加
 *
 * @param name
 *
 * 示例：
 * 查询商店：
 * url：https://rancher_api_url/v3/projectCatalogs/your_project_id:your_name
 * method:GET
 *
 */
def isExist(String projectId, String name) {
    def response
    try {
        println("---------------【查找应用商店】开始--------------")
        Application application = new Application()
        response =  application.handleRequest("GET","projectCatalogs/${projectId}:${name}", null)
        println("---------------【查找应用商店】开始--------------")
    } catch(Exception e) {
        e.printStackTrace()
        println(response)
        println(response.status)
        println(response.content)
    }
}

/**
 * 添加一个应用商店
 *
 * 示例：
 *  添加商店：
 *  url: https://rancher_api_url/v3/projectcatalog
 *  method:POST
 *  request payload：
 *  {
 *  "type": "projectcatalog",
 *  "kind": "helm",
 *  "branch": "your_branch",
 *  "projectId": "your_full_project_id",
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
    def response
    try {
        response = application.handleRequest("POST","projectcatalog", "${requestBody}")
    } catch (Exception e) {
        e.printStackTrace()
    } finally {
        println(response.status)
        println(response.content)
        println("---------------【添加Git仓库地址到应用商店】结束--------------")
    }
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