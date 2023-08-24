
    <jsp:include page="../INDEX/Action.jsp" flush="true"/>
    <div class="col-12 grid-margin stretch-card">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Nouveau categorie</h4>
            <form method="post" class="forms-sample" enctype="multipart/form-data" action="/Gestion/insertion-categorie.st">
                <div class="form-group">
                  <label for="exampleInputName1">Designation</label>
                  <input type="text" name="designation" class="form-control" id="exampleInputName1" placeholder="Product">
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail3">Reference</label>
                  <input type="text" name="referenceCategorie" class="form-control" id="exampleInputEmail3" placeholder="XXXXXXXX">
                </div>
                
                <button type="submit" class="btn btn-primary mr-2">Submit</button>
                <button class="btn btn-light">Cancel</button>
              </form>
        </div>
    </div>
    </div>
    <jsp:include page="../INDEX/footer.jsp" flush="true"/>