import devops.Utils

def deployApp(params) {
    Utils.parse()
    def url = params["url"]
    def namespace = params["namespace"]
    println("deploy app from url:${url} to namespace:${namespace} success.")
}
