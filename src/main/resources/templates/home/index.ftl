<#import "../base.ftl" as layout>

<@layout.mainLayout>
    <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th scope="col">Transaction ID</th>
              <th scope="col">Created Date</th>
              <th scope="col">Product</th>
              <th scope="col">Type</th>
              <th scope="col">Price</th>
            </tr>
          </thead>
          <tbody>
            <#list items as item>
              <tr>
                <td>${item.orderNumber}-${item.lineNumber}</td>
                <td>${(item.created).format("dd/MM/yyyy HH:mm")}</td>
                <td>${item.product}</td>
                <td>${item.type}</td>
                <td>${item.price?string.currency}</td>
              </tr>
            </#list>
          </tbody>
        </table>
      </div>
</@layout.mainLayout>