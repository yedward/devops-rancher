def info() {
    println("rancher info .............")
}

def deployApp(params) {
    def url = params["url"]
    def namespace = params["namespace"]
    println("deploy app from url:${url} to namespace:${namespace} success.")
}
