<#import "../base.ftl" as layout>

<@layout.mainLayout>
  <form class="needs-validation" action="/upload-file" method="post" enctype="multipart/form-data">
    <div class="row">
      <div class="col-sm-6">
        <label for="upload" class="form-label">File to upload</label>
        <input type="file" class="form-control" name="upload" id="upload" placeholder="Select file to upload" value="" required="">
        <div class="invalid-feedback">
          File required
        </div>
      </div>
    </div>
    <hr class="my-4" />
    <button class="btn btn-primary btn-lg" type="submit">Upload</button>
  </form>
</@layout.mainLayout>