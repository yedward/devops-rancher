import devops.RancherApps
import devops.RancherCatalog
import devops.Utils

def deployApp(params) {
    def API_SERVER_URL = "https://rancher.yedward.net/v3"
    def API_TOKEN = "token-vntwr:8cshhnnjrm4pvn2pm2fjph6mbczdhz2pn2vq27d77fnq2hkvbxmgn6"
    def url = params["url"]
    def namespace = params["namespace"]
    Utils helper = new Utils()
    result = helper.handleRequest("https://rancher.yedward.net/v3", "token-vntwr:8cshhnnjrm4pvn2pm2fjph6mbczdhz2pn2vq27d77fnq2hkvbxmgn6", "POST", "")
    RancherCatalog catalog = new RancherCatalog()
    catalog.add("https://rancher.yedward.net/v3", "token-vntwr:8cshhnnjrm4pvn2pm2fjph6mbczdhz2pn2vq27d77fnq2hkvbxmgn6","c-92nlp:p-jr7r6","testtestaaa","http://sdfsdf.github.com/sdfsd.git","master", "adminaa", "sdfsdfsdf")

//    result = httpRequest customHeaders: [[maskValue: true, name: 'Authorization', value: "Bearer token-vntwr:8cshhnnjrm4pvn2pm2fjph6mbczdhz2pn2vq27d77fnq2hkvbxmgn6"],
//                                         [maskValue: false, name: 'Content-Type', value: 'application/json'],
//                                         [maskValue: false, name: 'Accept', value: 'application/json']],
//            httpMode: "POST",
//            consoleLogResponseBody: true,
//            ignoreSslErrors: true,
//            requestBody: "",
//            url: "https://rancher.yedward.net/v3"
    println("deploy app from url:${url} to namespace:${namespace} success.")
    println(result.toString())
}

// project_id
// project_catalog_name
// project_catalog_url
// project_catalog_branch
// project_catalog_username
// project_catalog_password


// 添加商店：
// url: https://rancher_url/v3/projectcatalog
// method:POST
// request payload：
// {
//	"type": "projectcatalog",
//	"kind": "helm",
//	"branch": "master",
//	"projectId": "c-92nlp:p-jr7r6",
//	"helmVersion": "helm_v3",
//	"name": "testcharts",
//	"url": "https://github.com/yedward/testcharts.git",
//	"username": "admin",
//	"password": "admin888"
// }


