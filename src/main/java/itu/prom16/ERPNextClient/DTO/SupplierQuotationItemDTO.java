package itu.prom16.ERPNextClient.DTO;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Fanou
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupplierQuotationItemDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("owner")
    private String owner;

    @JsonProperty("creation")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime creation;

    @JsonProperty("modified")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime modified;

    @JsonProperty("modified_by")
    private String modifiedBy;

    @JsonProperty("docstatus")
    private int docstatus;

    @JsonProperty("idx")
    private int idx;

    @JsonProperty("item_code")
    private String itemCode;

    @JsonProperty("item_name")
    private String itemName;

    @JsonProperty("lead_time_days")
    private int leadTimeDays;

    @JsonProperty("is_free_item")
    private int isFreeItem;

    @JsonProperty("description")
    private String description;

    @JsonProperty("item_group")
    private String itemGroup;

    @JsonProperty("image")
    private String image;

    @JsonProperty("qty")
    private double qty;

    @JsonProperty("stock_uom")
    private String stockUom;

    @JsonProperty("uom")
    private String uom;

    @JsonProperty("conversion_factor")
    private double conversionFactor;

    @JsonProperty("stock_qty")
    private double stockQty;

    @JsonProperty("price_list_rate")
    private double priceListRate;

    @JsonProperty("discount_percentage")
    private double discountPercentage;

    @JsonProperty("discount_amount")
    private double discountAmount;

    @JsonProperty("distributed_discount_amount")
    private double distributedDiscountAmount;

    @JsonProperty("base_price_list_rate")
    private double basePriceListRate;

    @JsonProperty("rate")
    private double rate;

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("base_rate")
    private double baseRate;

    @JsonProperty("base_amount")
    private double baseAmount;

    @JsonProperty("pricing_rules")
    private String pricingRules;

    @JsonProperty("net_rate")
    private double netRate;

    @JsonProperty("net_amount")
    private double netAmount;

    @JsonProperty("base_net_rate")
    private double baseNetRate;

    @JsonProperty("base_net_amount")
    private double baseNetAmount;

    @JsonProperty("weight_per_unit")
    private double weightPerUnit;

    @JsonProperty("total_weight")
    private double totalWeight;

    @JsonProperty("warehouse")
    private String warehouse;

    @JsonProperty("item_tax_rate")
    private String itemTaxRate;

    @JsonProperty("cost_center")
    private String costCenter;

    @JsonProperty("page_break")
    private int pageBreak;

    @JsonProperty("parent")
    private String parent;

    @JsonProperty("parentfield")
    private String parentField;

    @JsonProperty("parenttype")
    private String parentType;

    @JsonProperty("doctype")
    private String doctype;

    public SupplierQuotationItemDTO() {
    }

    public SupplierQuotationItemDTO(String name, String owner, LocalDateTime creation, LocalDateTime modified, String modifiedBy, int docstatus, int idx, String itemCode, String itemName, int leadTimeDays, int isFreeItem, String description, String itemGroup, String image, double qty, String stockUom, String uom, double conversionFactor, double stockQty, double priceListRate, double discountPercentage, double discountAmount, double distributedDiscountAmount, double basePriceListRate, double rate, double amount, double baseRate, double baseAmount, String pricingRules, double netRate, double netAmount, double baseNetRate, double baseNetAmount, double weightPerUnit, double totalWeight, String warehouse, String itemTaxRate, String costCenter, int pageBreak, String parent, String parentField, String parentType, String doctype) {
        this.name = name;
        this.owner = owner;
        this.creation = creation;
        this.modified = modified;
        this.modifiedBy = modifiedBy;
        this.docstatus = docstatus;
        this.idx = idx;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.leadTimeDays = leadTimeDays;
        this.isFreeItem = isFreeItem;
        this.description = description;
        this.itemGroup = itemGroup;
        this.image = image;
        this.qty = qty;
        this.stockUom = stockUom;
        this.uom = uom;
        this.conversionFactor = conversionFactor;
        this.stockQty = stockQty;
        this.priceListRate = priceListRate;
        this.discountPercentage = discountPercentage;
        this.discountAmount = discountAmount;
        this.distributedDiscountAmount = distributedDiscountAmount;
        this.basePriceListRate = basePriceListRate;
        this.rate = rate;
        this.amount = amount;
        this.baseRate = baseRate;
        this.baseAmount = baseAmount;
        this.pricingRules = pricingRules;
        this.netRate = netRate;
        this.netAmount = netAmount;
        this.baseNetRate = baseNetRate;
        this.baseNetAmount = baseNetAmount;
        this.weightPerUnit = weightPerUnit;
        this.totalWeight = totalWeight;
        this.warehouse = warehouse;
        this.itemTaxRate = itemTaxRate;
        this.costCenter = costCenter;
        this.pageBreak = pageBreak;
        this.parent = parent;
        this.parentField = parentField;
        this.parentType = parentType;
        this.doctype = doctype;
    }

    public String getName() { return name;}
    public void setName(String name) {this.name = name; }

    public String getOwner() { return owner;}
    public void setOwner(String owner) {this.owner = owner; }

    public LocalDateTime getCreation() { return creation;}
    public void setCreation(LocalDateTime creation) {this.creation = creation; }

    public LocalDateTime getModified() { return modified;}
    public void setModified(LocalDateTime modified) {this.modified = modified; }

    public String getModifiedBy() { return modifiedBy;}
    public void setModifiedBy(String modifiedBy) {this.modifiedBy = modifiedBy; }

    public int getDocstatus() { return docstatus;}
    public void setDocstatus(int docstatus) {this.docstatus = docstatus; }

    public int getIdx() { return idx;}
    public void setIdx(int idx) {this.idx = idx; }

    public String getItemCode() { return itemCode;}
    public void setItemCode(String itemCode) {this.itemCode = itemCode; }

    public String getItemName() { return itemName;}
    public void setItemName(String itemName) {this.itemName = itemName; }

    public int getLeadTimeDays() { return leadTimeDays;}
    public void setLeadTimeDays(int leadTimeDays) {this.leadTimeDays = leadTimeDays; }

    public int getIsFreeItem() { return isFreeItem;}
    public void setIsFreeItem(int isFreeItem) {this.isFreeItem = isFreeItem; }

    public String getDescription() { return description;}
    public void setDescription(String description) {this.description = description; }

    public String getItemGroup() { return itemGroup;}
    public void setItemGroup(String itemGroup) {this.itemGroup = itemGroup; }

    public String getImage() { return image;}
    public void setImage(String image) {this.image = image; }

    public double getQty() { return qty;}
    public void setQty(double qty) {this.qty = qty; }

    public String getStockUom() { return stockUom;}
    public void setStockUom(String stockUom) {this.stockUom = stockUom; }

    public String getUom() { return uom;}
    public void setUom(String uom) {this.uom = uom; }

    public double getConversionFactor() { return conversionFactor;}
    public void setConversionFactor(double conversionFactor) {this.conversionFactor = conversionFactor; }

    public double getStockQty() { return stockQty;}
    public void setStockQty(double stockQty) {this.stockQty = stockQty; }

    public double getPriceListRate() { return priceListRate;}
    public void setPriceListRate(double priceListRate) {this.priceListRate = priceListRate; }

    public double getDiscountPercentage() { return discountPercentage;}
    public void setDiscountPercentage(double discountPercentage) {this.discountPercentage = discountPercentage; }

    public double getDiscountAmount() { return discountAmount;}
    public void setDiscountAmount(double discountAmount) {this.discountAmount = discountAmount; }

    public double getDistributedDiscountAmount() { return distributedDiscountAmount;}
    public void setDistributedDiscountAmount(double distributedDiscountAmount) {this.distributedDiscountAmount = distributedDiscountAmount; }

    public double getBasePriceListRate() { return basePriceListRate;}
    public void setBasePriceListRate(double basePriceListRate) {this.basePriceListRate = basePriceListRate; }

    public double getRate() { return rate;}
    public void setRate(double rate) {this.rate = rate; }

    public double getAmount() { return amount;}
    public void setAmount(double amount) {this.amount = amount; }

    public double getBaseRate() { return baseRate;}
    public void setBaseRate(double baseRate) {this.baseRate = baseRate; }

    public double getBaseAmount() { return baseAmount;}
    public void setBaseAmount(double baseAmount) {this.baseAmount = baseAmount; }

    public String getPricingRules() { return pricingRules;}
    public void setPricingRules(String pricingRules) {this.pricingRules = pricingRules; }

    public double getNetRate() { return netRate;}
    public void setNetRate(double netRate) {this.netRate = netRate; }

    public double getNetAmount() { return netAmount;}
    public void setNetAmount(double netAmount) {this.netAmount = netAmount; }

    public double getBaseNetRate() { return baseNetRate;}
    public void setBaseNetRate(double baseNetRate) {this.baseNetRate = baseNetRate; }

    public double getBaseNetAmount() { return baseNetAmount;}
    public void setBaseNetAmount(double baseNetAmount) {this.baseNetAmount = baseNetAmount; }

    public double getWeightPerUnit() { return weightPerUnit;}
    public void setWeightPerUnit(double weightPerUnit) {this.weightPerUnit = weightPerUnit; }

    public double getTotalWeight() { return totalWeight;}
    public void setTotalWeight(double totalWeight) {this.totalWeight = totalWeight; }

    public String getWarehouse() { return warehouse;}
    public void setWarehouse(String warehouse) {this.warehouse = warehouse; }

    public String getItemTaxRate() { return itemTaxRate;}
    public void setItemTaxRate(String itemTaxRate) {this.itemTaxRate = itemTaxRate; }

    public String getCostCenter() { return costCenter;}
    public void setCostCenter(String costCenter) {this.costCenter = costCenter; }

    public int getPageBreak() { return pageBreak;}
    public void setPageBreak(int pageBreak) {this.pageBreak = pageBreak; }

    public String getParent() { return parent;}
    public void setParent(String parent) {this.parent = parent; }

    public String getParentField() { return parentField;}
    public void setParentField(String parentField) {this.parentField = parentField; }

    public String getParentType() { return parentType;}
    public void setParentType(String parentType) {this.parentType = parentType; }

    public String getDoctype() { return doctype;}
    public void setDoctype(String doctype) {this.doctype = doctype; }
}
